package com.example.toxic_pizzaui.controller;

import com.example.toxic_pizzaui.Tp_Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class cartController {
    @FXML
    private Label TAXlabel;

    @FXML
    private Label subTotalLabel;

    @FXML
    private Label totalPriceLabel;

    @FXML
    public void goBack(ActionEvent event) throws IOException{
        Tp_Utils.changeScene(event, "MainPage.fxml");
    }





}
