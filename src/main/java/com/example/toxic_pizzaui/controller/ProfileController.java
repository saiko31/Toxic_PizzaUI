package com.example.toxic_pizzaui.controller;

import com.example.toxic_pizzaui.Tp_Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class ProfileController {
    Button userButton;

    /*All the code related to the user profile page goes here: action buttons, order history, update information, etc.*/

    @FXML
    public void backBtn(ActionEvent event) throws IOException {
        Tp_Utils.changeScene(event, "root.fxml");
    }

}
