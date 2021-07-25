package com.krunalkaneria.todolist.datamodel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;

public class TodoClass {
    private static TodoClass instance = new TodoClass();
    private static String filename = "TodoItems.txt";
    private ObservableList<TodoItem> todoItems;
    private DateTimeFormatter df;


    public static TodoClass getInstance() {
        return instance;
    }

    private TodoClass(){
        df = DateTimeFormatter.ofPattern("d MMMM, yyyy");
    }

    public ObservableList<TodoItem> getTodoItems() {
        return todoItems;
    }

    public void addTodoItem(TodoItem item) {
        this.todoItems.add(item);
    }

    public void deleteTodoItem(TodoItem item) {
        todoItems.remove(item);
    }



//        public void setTodoItems(List<TodoItem> todoItems) {
//        this.todoItems = todoItems;
//    }

    public void loadTodoItems() throws IOException {
        todoItems = FXCollections.observableArrayList();
        Path path = Paths.get(filename);
        BufferedReader br = Files.newBufferedReader(path);
        String input;
        try {

            while((input = br.readLine())!=null) {
                String[] itemPieces = input.split("\t");

                String shortDescription = itemPieces[0];
                String detailDescription = itemPieces[1];
                String dateString = itemPieces[2];

                LocalDate date = LocalDate.parse(dateString,df);
                TodoItem todoItem = new TodoItem(shortDescription,detailDescription,date);
                todoItems.add(todoItem);
            }
        }finally {
            if(br!=null) {
                br.close();
            }
        }

    }

    public void storeTodoItem() throws IOException {
        Path path = Paths.get(filename);
        BufferedWriter bw = Files.newBufferedWriter(path);
        try {
            Iterator<TodoItem>iterator = todoItems.iterator();
            while (iterator.hasNext()) {
                TodoItem item = iterator.next();
                bw.write(String.format("%s\t%s\t%s",item.getShortDescription(),item.getDetail(),item.getDeadline().format(df)));
                bw.newLine();
            }
        } finally {
            if(bw!=null) {
                bw.close();
            }
        }
    }

}
