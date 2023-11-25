package com.example.toxic_pizzaui.controller;


import com.example.toxic_pizzaui.objects.Tp_Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;

import java.io.IOException;


public class createPizzaController {
    @FXML
    private ToggleButton fPizza;

    @FXML
    private ToggleButton mPizza;

    @FXML
    private ToggleButton LPIzza;

    @FXML
    private Text price;

    @FXML
    private ToggleButton smallPizza;

    @FXML
    private ToggleGroup toppingsBtn;

    @FXML
    private ToggleGroup pizzaSizes;

    @FXML
    private ToggleGroup crustBtn;

    private static final int toppingLimit = 4;  //Sets the limit of toppings options to only 4

    private void pizzaSizeSelection(ActionEvent e) throws IOException {
        fPizza.setOnAction(event -> {price.setText("Price");});
    }


    private void toppingsLimit(){

    }

}
