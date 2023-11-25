package com.example.toxic_pizzaui.controller;

import com.example.toxic_pizzaui.objects.Tp_Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class SignUpController {

    @FXML
    private void backBtn(ActionEvent e){
        Tp_Utils.changeScene(e, "loginPage.fxml");
    }
}
