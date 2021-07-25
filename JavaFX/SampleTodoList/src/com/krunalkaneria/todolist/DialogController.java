package com.krunalkaneria.todolist;

import com.krunalkaneria.todolist.datamodel.TodoClass;
import com.krunalkaneria.todolist.datamodel.TodoItem;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class DialogController {
    @FXML
    private TextField shortdescription;
    @FXML
    private TextArea detailsArea;
    @FXML
    private DatePicker deadlinePicker;

    public TodoItem processResult() {
        String shortdescriptionField = shortdescription.getText().trim();
        String details = detailsArea.getText().trim();
        LocalDate deadlineValue = deadlinePicker.getValue();
        TodoItem newItem = new TodoItem(shortdescriptionField,details,deadlineValue);
        TodoClass.getInstance().addTodoItem(newItem);
        return newItem;
    }
}
