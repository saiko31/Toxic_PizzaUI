package com.example.toxic_pizzaui.controller;

import com.example.toxic_pizzaui.DataHandling.OrderController;
import com.example.toxic_pizzaui.Tp_Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.io.IOException;

public class DeliveryController {
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
            OrderController.getOrder().setDeliveryOption("Home Delivery");
            enterAdressPane.setVisible(true);
        }
        else if(pickupBtn.isSelected()){
            OrderController.getOrder().setDeliveryOption("In-Store Pickup");
            enterAdressPane.setVisible(false);
        }
    }


    @FXML
    private void backBtn(ActionEvent e) throws IOException{
        AppBarController.getInstance().changeScreen("MainPage.fxml");
        AppBarController.getInstance().setProfileBtn(false);
    }

    @FXML
    private void continueBtn(ActionEvent e){
        if(deliveryBtn.isSelected() && (addressLine.getText().isEmpty() == true || cityLine.getText().isEmpty() == true || zip_line.getText().isEmpty() == true)){
            Tp_Utils.showMessage("ERROR", "Please enter your delivery information");
        } else if (!deliveryBtn.isSelected() && !pickupBtn.isSelected()) {
            Tp_Utils.showMessage("ERROR", "Please select a delivery option");
        } else{
            AppBarController.getInstance().changeScreen("pizzaCreation.fxml");
        }
    }



}
