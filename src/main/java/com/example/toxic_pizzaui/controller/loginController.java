package com.example.toxic_pizzaui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class loginController {
    @FXML
    private Label welcomeText;

    @FXML
    private Stage primaryStage;


    private Alert loginAlert;
    @FXML
    protected void login(ActionEvent e) throws IOException {
       /* loginAlert = new Alert(Alert.AlertType.INFORMATION);
        loginAlert.setTitle("Test");
        loginAlert.setContentText("This is a test");
        loginAlert.getDialogPane().getStylesheets().add("/.style/buttons.css");
        loginAlert.showAndWait();*/


        Parent root = FXMLLoader.load(getClass().getResource("/com/example/toxic_pizzaui/.fxml/MainPage.fxml"));
        primaryStage = new Stage();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}