package sample.controllers;

import animatefx.animation.*;
import com.itextpdf.text.Anchor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.security.auth.login.LoginContext;
import java.io.IOException;

public class SettingsController {

    @FXML
    private AnchorPane MainPane;

    @FXML
    private VBox Vbox;

    @FXML
    private Button AdminButton, LogOutButton, BackButton;

    @FXML
    void initialize() {
        Vbox.setOpacity(0);
        new ZoomIn(Vbox).play();

        AdminButton.setOnAction(event -> {
            FadeOutDownBig animation = new FadeOutDownBig(Vbox);
            animation.setOnFinished(event1 -> showScene("/sample/fxml/Admin.fxml"));
            animation.play();
        });

//        LogOutButton.setOnAction(event -> {
//            showScene("/sample/fxml/Delete1.fxml", event);
//        });

        BackButton.setOnAction(event -> {
            ZoomOut animation = new ZoomOut(Vbox);
            animation.setOnFinished(event1 -> showScene("/sample/fxml/reMain.fxml"));
            animation.play();

        });
    }


    public void showScene(String window) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(window));
            Scene scene = new Scene(root);
            Stage stage = (Stage) MainPane.getScene().getWindow();
            stage.setScene(scene);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}


