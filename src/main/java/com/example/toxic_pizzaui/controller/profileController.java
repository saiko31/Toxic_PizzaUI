package com.example.toxic_pizzaui.controller;

import com.example.toxic_pizzaui.Tp_Utils;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class profileController {
    Button userButton;

    /*All the code related to the user profile page goes here: action buttons, order history, update information, etc.*/

    @FXML
    public void backBtn(ActionEvent event) throws IOException {
        Tp_Utils.changeScene(event, "root.fxml");
    }

}
