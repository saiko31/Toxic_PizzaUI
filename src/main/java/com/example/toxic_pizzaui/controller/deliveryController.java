package com.example.toxic_pizzaui.controller;

import com.example.toxic_pizzaui.Tp_Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.io.IOException;

public class deliveryController {
    @FXML
    private ToggleGroup deliveryOptions;

    @FXML
    private Pane enterAdressPane;

    @FXML
    private Pane messagePane;

    @FXML
    private ToggleButton deliveryBtn;

    @FXML
    private ToggleButton pickupBtn;

    @FXML
    private TextField addressLine;

    @FXML
    private TextField cityLine;

    @FXML
    private TextField zip_line;

    @FXML
    private Text message;



    @FXML
    private void deliverySelection(ActionEvent e) throws IOException {
        if(deliveryBtn.isSelected()){
            enterAdressPane.setVisible(true);
        }
        else if(pickupBtn.isSelected()){
            enterAdressPane.setVisible(false);
        }
    }


    @FXML
    private void backBtn(ActionEvent e) throws IOException{
        Tp_Utils.changeScene(e,"MainPage.fxml");
    }

    @FXML
    private void continueBtn(ActionEvent e){
        if(deliveryBtn.isSelected() && addressLine.getText().isEmpty() == true && cityLine.getText().isEmpty() == true && zip_line.getText().isEmpty() == true){
            messagePane.setVisible(true);
            message.setText("Please enter your address or select another delivery option");
        }
        else{
            AppBarController.getInstance().changeScreen("pizzaCreation.fxml");
        }
    }



}
