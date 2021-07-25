package com.krunalkaneria.todolist;

import com.krunalkaneria.todolist.datamodel.TodoClass;
import com.krunalkaneria.todolist.datamodel.TodoItem;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.util.Callback;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Optional;
import java.util.function.Predicate;

public class Controller {
//    private List<TodoItem>todoItems = new ArrayList<>();

    @FXML
    private ListView<TodoItem> todoListView;
    @FXML
    private TextArea itemDetailsTextArea;
    @FXML
    private Label deadLineLabel;
    @FXML
    private BorderPane mainBorderPane;
    @FXML
    private ContextMenu listContextMenu;
    @FXML
    private ToggleButton filterToggleButton;
    @FXML
    private FilteredList<TodoItem>filteredList;
    private Predicate<TodoItem>wantAllItems;
    private Predicate<TodoItem>wantSelectedItems;

    public void initialize() {
        listContextMenu = new ContextMenu();
        MenuItem deleteMenuItem = new MenuItem("Delete");
        deleteMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                TodoItem item = todoListView.getSelectionModel().getSelectedItem();
                deleteItem(item);
            }
        });
        listContextMenu.getItems().addAll(deleteMenuItem);
//        TodoItem item1 = new TodoItem("Mail Birthday Card","Buy a new Birthday card for John for 30th May",
//                LocalDate.of(2020, Month.MAY,30));
//        TodoItem item2 = new TodoItem("Buy Eggs","Buy eggs for Lunch",
//                LocalDate.of(2020,Month.APRIL,4));
//        TodoItem item3 = new TodoItem("Save Money For Phone","Start saving money to Buy a new Phone.",
//                LocalDate.of(2021, Month.SEPTEMBER,21));
//        TodoItem item4 = new TodoItem("Doctor Appointment","Doctor Appointment at John Street 35.",
//                LocalDate.of(2019, Month.JANUARY,31));

//        todoItems.add(item1);
//        todoItems.add(item2);
//        todoItems.add(item3);
//        todoItems.add(item4);
        todoListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TodoItem>() {
            @Override
            public void changed(ObservableValue<? extends TodoItem> observableValue, TodoItem todoItem, TodoItem newValue) {
                if(newValue!=null) {
                    TodoItem item = todoListView.getSelectionModel().getSelectedItem();
                    itemDetailsTextArea.setText(item.getDetail());
                    DateTimeFormatter df = DateTimeFormatter.ofPattern("d MMMM, yyyy");
                    deadLineLabel.setText(df.format(item.getDeadline()));
                }
            }
        });




        todoListView.setCellFactory(new Callback<ListView<TodoItem>, ListCell<TodoItem>>() {
            @Override
            public ListCell<TodoItem> call(ListView<TodoItem> todoItemListView) {
                ListCell<TodoItem>cell = new ListCell<>() {
                    @Override
                    protected void updateItem(TodoItem item, boolean b) {
                        super.updateItem(item, b);
                        if(b) {
                            setText(null);
                        } else {
                            setText(item.getShortDescription());
                            if((item.getDeadline().equals(LocalDate.now())) || (item.getDeadline().isBefore(LocalDate.now()))) {
                                setTextFill(Color.RED);
                            }
                            else if(item.getDeadline().equals(LocalDate.now().plusDays(1))) {
                                setTextFill(Color.CHOCOLATE);
                            }
                        }
                    }

                };
                cell.emptyProperty().addListener(
                        (obs,wasEmpty,isNowEmpty) -> {
                    if(isNowEmpty) {
                        cell.setContextMenu(null);
                    }
                    else {
                        cell.setContextMenu(listContextMenu);
                    }
                });
                return cell;
            }
        });
        wantAllItems = new Predicate<TodoItem>() {
            @Override
            public boolean test(TodoItem todoItem) {
                return true;
            }
        };

        wantSelectedItems = new Predicate<TodoItem>() {
            @Override
            public boolean test(TodoItem todoItem)   {
                return todoItem.getDeadline().equals(LocalDate.now());
            }
        };

        filteredList = new FilteredList<TodoItem>(TodoClass.getInstance().getTodoItems(),
                new Predicate<TodoItem>() {
                    @Override
                    public boolean test(TodoItem todoItem) {
                        return true;
                    }
                });

        SortedList<TodoItem>sortedList = new SortedList<TodoItem>(filteredList,
                new Comparator<TodoItem>() {
                    @Override
                    public int compare(TodoItem o1, TodoItem o2) {
                        return o1.getDeadline().compareTo(o2.getDeadline());
                    }
                });
//        TodoClass.getInstance().setTodoItems(todoItems);
//        todoListView.getItems().setAll(TodoClass.getInstance().getTodoItems());
//        todoListView.setItems(TodoClass.getInstance().getTodoItems());
        todoListView.setItems(sortedList);
        todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        todoListView.getSelectionModel().selectFirst();


    }

    @FXML
    public void showMenuDialog() {
        Dialog<ButtonType>dialog = new Dialog<>();
        dialog.setTitle("Add A New Todo List Item");
        dialog.setHeaderText("Use This To Add A New ToDo Item");
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        FXMLLoader fxmlloader = new FXMLLoader();
        fxmlloader.setLocation(getClass().getResource("todoDialog.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlloader.load());
        } catch (IOException e) {
            System.out.println("Couldn't Load the Dialog.");
            e.printStackTrace();
            return;
        }
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
        Optional<ButtonType>result = dialog.showAndWait();
        if(result.isPresent() && result.get() == ButtonType.OK) {
            DialogController controller = fxmlloader.getController();
            TodoItem newItem = controller.processResult();
//            todoListView.getItems().setAll(TodoClass.getInstance().getTodoItems());
            todoListView.getSelectionModel().select(newItem);
        }


    }


    @FXML
    public void handleClickListView(){
        TodoItem item = todoListView.getSelectionModel().getSelectedItem();
        itemDetailsTextArea.setText(item.getDetail());
        deadLineLabel.setText(item.getDeadline().toString());
//        StringBuilder sb = new StringBuilder(item.getDetail());
//        sb.append("\n\n\n\n\n");
//        sb.append("Due Date: ");
//        sb.append(item.getDeadline().toString());
//        System.out.println("The selected item is " + item);
//        itemDetailsTextArea.setText(sb.toString());
    }

    @FXML
    public void handleKeyPressed(KeyEvent keyEvent) {
        TodoItem selectedItem = todoListView.getSelectionModel().getSelectedItem();
        if(selectedItem!=null) {
            if(keyEvent.getCode().equals(KeyCode.DELETE)) {
                deleteItem(selectedItem);
            }
        }
    }

    public void deleteItem(TodoItem item) {
        Alert alert = new Alert (Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Todo Item");
        alert.setHeaderText("Delete Item: " + item.getShortDescription());
        alert.setContentText("Are You Sure to Delete The Item. Press OK to Delete.");
        Optional<ButtonType>result = alert.showAndWait();
        if(result.isPresent() && (result.get() == ButtonType.OK)) {
            TodoClass.getInstance().deleteTodoItem(item);
        }
    }
    @FXML
    public void handleFilter() {
        TodoItem selecteditem = todoListView.getSelectionModel().getSelectedItem();
        if(filterToggleButton.isSelected()) {
            filteredList.setPredicate(wantSelectedItems);
            if(filteredList.isEmpty()) {
                itemDetailsTextArea.clear();
                deadLineLabel.setText("");
            } else if(filteredList.contains(selecteditem)) {
                todoListView.getSelectionModel().select(selecteditem);
            } else {
                todoListView.getSelectionModel().selectFirst();
            }
        } else {
            filteredList.setPredicate(wantAllItems);
        }
    }
    @FXML
    public void handleExit() {
        Platform.exit();
    }
}
