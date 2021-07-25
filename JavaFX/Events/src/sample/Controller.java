package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private TextField nameField;
    @FXML
    private Button helloButton;
    @FXML
    private Button byeButton;
    @FXML
    private CheckBox ourcheckBox;
    @FXML
    private Label ourLabel;

    @FXML
    public void initialize() {
        helloButton.setDisable(true);
        byeButton.setDisable(true);
    }

    @FXML
    public void onButtonClicked(ActionEvent e) {
        if(e.getSource().equals(helloButton)) {
            System.out.println("Hello, "+ nameField.getText());
        }
        else if(e.getSource().equals(byeButton)) {
            System.out.println("Bye, " + nameField.getText());
        }

        Runnable task = new Runnable() {
            @Override
            public void run() {
                try{
                    String s = Platform.isFxApplicationThread() ? "UI Thread" : "Background Thread.";
                    System.out.println("I'm running on the " + s);
                    Thread.sleep(10000);
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            String s = Platform.isFxApplicationThread() ? "UI Thread" : "Background Thread.";
                            System.out.println("I'm updating the Label on the " + s);
                            ourLabel.setText("We did Something..");
                        }
                    });

                }
                catch(InterruptedException event) {
            //We don't care about this..S
                }
            }
        };
        new Thread(task).start();

        if(ourcheckBox.isSelected()) {
            nameField.clear();
            helloButton.setDisable(true);
            byeButton.setDisable(true);
        }
    }

    @FXML
    public void handleKeyRelease() {
        String text = nameField.getText();
        boolean isEmpty = text.isEmpty() || text.trim().isEmpty();
        helloButton.setDisable(isEmpty);
        byeButton.setDisable(isEmpty);
    }

    @FXML
    public void checkBoxstate(){
        System.out.println("Our Checkbox is " + ((ourcheckBox.isSelected()) ? "Checked" : "Not Checked"));
    }

}
