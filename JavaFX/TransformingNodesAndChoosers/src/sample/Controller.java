package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.*;
import javafx.scene.input.MouseEvent;
import java.awt.Desktop;
import javafx.scene.layout.GridPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.EventListener;

public class Controller {
    @FXML
    private Label label;
    @FXML
    private Button buttonfour;
    @FXML
    private Button buttonone;
    @FXML
    private GridPane gridpane;


    public void initialize() {
//        label.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent mouseEvent) {
//                label.setScaleX(2.0);
//                label.setScaleY(2.0);
//            }
//        });
//        label.onMouseExitedProperty().setValue(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent mouseEvent) {
//                label.setScaleY(1.0);
//                label.setScaleX(1.0);
//            }
//        });
//        buttonfour.setEffect(new DropShadow());
    }

    @FXML
    public void handleMouseEnter() {
        label.setScaleX(2.0);
        label.setScaleY(2.0);
    }
    @FXML
    public void handleMouseExit() {
        label.setScaleY(1.0);
        label.setScaleX(1.0);
    }

    @FXML
    public void handleClick(){
        FileChooser chooser = new FileChooser();
        chooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text","*.txt"),
                new FileChooser.ExtensionFilter("PDF","*.pdf"),
                new FileChooser.ExtensionFilter("Image Files","*.img","*.jpg","*.jpeg","*.png"),
                new FileChooser.ExtensionFilter("All Files","*.*")
        );
        File file = chooser.showOpenDialog(gridpane.getScene().getWindow());
        chooser.setTitle("Save Application File");

        if(file!=null) {
            System.out.println(file.getPath());
        } else {
            System.out.println("Cancel Button Was Pressed");
        }
    }

    @FXML
    private WebView webview;

    @FXML
    public void handleLink() {
        WebEngine webEngine = webview.getEngine();
        webEngine.load("http://www.javafx.com");
    }


}
