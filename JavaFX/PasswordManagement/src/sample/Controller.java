package sample;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Callback;

import java.io.IOException;
import java.util.Comparator;
import java.util.Optional;

public class Controller {

    @FXML
    public ListView<Password>listview;
    @FXML
    private TextField titleField;
    @FXML
    private TextField passwordField;
    @FXML
    private TextField websiteField;
    @FXML
    private TextField usernameField;
    @FXML
    private BorderPane mainBorderPane;
    @FXML
    private ContextMenu listContextMenu;



    public void initialize() {


        //Change Listener Method of Listview
        listview.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Password>() {
            @Override
            public void changed(ObservableValue<? extends Password> observableValue, Password password, Password t1) {
                if (t1 != null) {
                    Password item = listview.getSelectionModel().getSelectedItem();
                    titleField.setText(item.getTitle());
                    passwordField.setText(item.getValue());
                    websiteField.setText(item.getWebsite());
                    usernameField.setText(item.getUsername());
                    titleField.setDisable(true);
                    usernameField.setDisable(true);
                    passwordField.setDisable(true);
                    websiteField.setDisable(true);
                }
            }
        });


        //*************************************************
        //Change Listeners For TextFields Which will Change The Text
        titleField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                listview.getSelectionModel().getSelectedItem().setTitle(t1);
            }
        });

        usernameField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                listview.getSelectionModel().getSelectedItem().setUsername(t1);
            }
        });

        passwordField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                listview.getSelectionModel().getSelectedItem().setValue(t1);
            }
        });

        websiteField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                listview.getSelectionModel().getSelectedItem().setWebsite(t1);
            }
        });
        //****************************************



        SortedList<Password>sortedList = new SortedList<>(PasswordData.getInstance().passwordList,
                new Comparator<Password>() {
                    @Override
                    public int compare(Password o1, Password o2) {
                        return o1.getTitle().compareToIgnoreCase(o2.getTitle());
                    }
                });
        listview.setItems(sortedList);
        listview.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        listview.getSelectionModel().selectFirst();

        //Add Cell Factory method to Display Right Click To Delete
        listview.setCellFactory(new Callback<ListView<Password>, ListCell<Password>>() {
            @Override
            public ListCell<Password> call(ListView<Password> passwordListView) {
                ListCell<Password>cell = new ListCell<>() {
                    @Override
                    protected void updateItem(Password password, boolean b) {
                        super.updateItem(password,b);
                        if(b) {
                            setText(null);
                        } else {
                            setText(password.toString());
                        }
                    }

                };
                cell.emptyProperty().addListener(
                        ((observableValue, wasEmpty, isEmpty) ->{
                            if(isEmpty) {
                                cell.setContextMenu(null);
                            }else {
                                cell.setContextMenu(listContextMenu);
                            }
                        } )
                );
                return cell;
            }

        });

        //Add A Context Menu To Display Delete Option on Right Click on Password Field
        listContextMenu = new ContextMenu();
        MenuItem deleteItem = new MenuItem("Delete");
//        MenuItem editItem = new MenuItem("Edit");
        deleteItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Password item =listview.getSelectionModel().getSelectedItem();
                deletePasswordField(item);
            }
        });
        listContextMenu.getItems().add(deleteItem);
//        listContextMenu.getItems().add(editItem);
    }

    //Creating a new Dialog To Add New Password To List And Saving The Information To File
    @FXML
    public void showNewMenu(){
        Dialog<ButtonType> dialog = new Dialog<>();
        FXMLLoader fxmlloader = new FXMLLoader();
        dialog.setTitle("Add A New Password");
        dialog.setHeaderText("Create A New Password");
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        fxmlloader.setLocation(getClass().getResource("newDialog.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlloader.load());
        } catch (IOException e) {
            System.out.println("Unable to Add The Dialog");
            e.printStackTrace();
            return;
        }
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
        Optional<ButtonType> result = dialog.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {
            NewDialogController controller = fxmlloader.getController();
            Password newItem = controller.processDialog();
            listview.getSelectionModel().select(newItem);
        }
    }

    @FXML
    public void handleExit() {
        Platform.exit();
    }



    public void deletePasswordField(Password item) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Password?");
        alert.setHeaderText("Delete Password of " + item.getTitle());
        alert.setContentText("Are You Sure You Want to Delete The Field");
        Optional<ButtonType>result =alert.showAndWait();
        if((result.isPresent()) && (result.get() == ButtonType.OK)) {
            PasswordData.getInstance().passwordList.remove(item);
        }
    }

    @FXML
    public void changeTitle() {
        titleField.setDisable(false);
    }

    @FXML
    public void changeUsername() {
        usernameField.setDisable(false);

    }

    @FXML
    public void changePassword() {
        passwordField.setDisable(false);
    }

    @FXML
    public void changeWebsite() {
        websiteField.setDisable(false);
    }

    @FXML
    public void copyText() {

    }


}
