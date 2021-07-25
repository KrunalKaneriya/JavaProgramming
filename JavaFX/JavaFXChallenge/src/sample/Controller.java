package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;

import java.io.IOException;
import java.util.Optional;


public class Controller {
    @FXML
    private BorderPane mainBorderPane;
    @FXML
    private TableView<Contact>tableView;
    @FXML
    private TableColumn<Contact, SimpleStringProperty>firstNameColumn;
    @FXML
    private TableColumn<Contact,SimpleStringProperty>lastNameColumn;
    @FXML
    private TableColumn<Contact,SimpleStringProperty>phoneNumberColumn;
    @FXML
    private TableColumn<Contact,SimpleStringProperty>notesColumn;

    private ContextMenu contextMenu;


    private ContactData contactData;

    public void initialize() {
        contactData = new ContactData();
        contactData.loadContacts();
        tableView.setItems(contactData.getContacts());
        contextMenu = new ContextMenu();
        MenuItem deleteItem = new MenuItem("Delete");
        MenuItem editItem = new MenuItem("Edit");
        deleteItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Contact selectedContact = tableView.getSelectionModel().getSelectedItem();
                deleteContact(selectedContact);
            }
        });
        editItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                editContact();
            }
        });
        contextMenu.getItems().add(deleteItem);
        contextMenu.getItems().add(editItem);
        tableView.setRowFactory(new Callback<TableView<Contact>, TableRow<Contact>>() {
            @Override
            public TableRow<Contact> call(TableView<Contact> contactTableView) {
                TableRow<Contact>item = new TableRow<>();
                item.emptyProperty().addListener(new ChangeListener<Boolean>() {
                    @Override
                    public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                        if(t1==null) {
                            item.setContextMenu(null);
                        } else {
                            item.setContextMenu(contextMenu);
                        }
                    }
                });
                return item;
            }
        });
//        firstNameColumn.prefWidthProperty().bind(tableView.widthProperty().multiply(.25));
//        lastNameColumn.prefWidthProperty().bind(tableView.widthProperty().multiply(.25));
//        phoneNumberColumn.prefWidthProperty().bind(tableView.widthProperty().multiply(.25));
//        notesColumn.prefWidthProperty().bind(tableView.widthProperty().multiply(.24));
        }


    @FXML
    public void addNewContactDialog() {
        Dialog<ButtonType> addDialog = new Dialog<>();
        addDialog.initOwner(mainBorderPane.getScene().getWindow());
        addDialog.setHeaderText("Add New Contact");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("addNewContact.fxml"));
        try {
            addDialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        addDialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        addDialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = addDialog.showAndWait();
        if (result.isPresent() && (result.get() == ButtonType.OK)) {
            System.out.println("We are Going To Process The Data");
            addNewContactController addNewContactController = fxmlLoader.getController();
            Contact returnedContact = addNewContactController.getNewContact();
            contactData.addContact(returnedContact);
            contactData.saveContacts();
        }
    }

    @FXML
    public void editContact() {
        Contact selectedContact = tableView.getSelectionModel().getSelectedItem();
        if(selectedContact==null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Contact is Not Selected");
            alert.setTitle("No Contact Selected");
            alert.showAndWait();
            return;
        }
        Dialog<ButtonType>dialog = new Dialog<>();
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        dialog.setTitle("Edit Contact");
        dialog.setHeaderText("Edit The Selected Contact");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("addNewContact.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
        addNewContactController contactController = fxmlLoader.getController();
        contactController.editContact(selectedContact);
        Optional<ButtonType>result = dialog.showAndWait();
        if(result.isPresent() && (result.get() == ButtonType.OK)) {
            contactController.updateContact(selectedContact);
            contactData.saveContacts();

        }
    }

    public void deleteContact(Contact selectedContact) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Contact");
        alert.setHeaderText("Do You Want to Delete The Contact?");
        Optional<ButtonType>result = alert.showAndWait();
        if(result.isPresent() && (result.get() == ButtonType.OK)) {
            contactData.removeContact(selectedContact);
            contactData.saveContacts();
        }
    }
}

