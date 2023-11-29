package com.example.toxic_pizzaui.controller;

import com.example.toxic_pizzaui.Tp_Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

import java.io.IOException;

public class MainPageController{

    AppBarController appBarController;



    private Stage stage;


    @FXML
    public void btnCrust(ActionEvent event) throws IOException{

    }


    @FXML
    public void btnToppings(ActionEvent event) throws IOException{

    }

    @FXML
    public void btnBeverages(ActionEvent event) throws  IOException{
    }



    @FXML
    private void startOrder(ActionEvent e) throws IOException{                      /// Press the "Start Order Button", will jump to the order type selection page
        AppBarController.getInstance().changeScreen("deliveryOptionPage.fxml");
        AppBarController.getInstance().disableProfileBtn();
    }

    @FXML
    private void seeProfile(ActionEvent e){
        Tp_Utils.changeScene(e, "userProfile.fxml");
    }

    @FXML
    public void goToCart(ActionEvent event) throws IOException{
        Tp_Utils.changeScene(event, "cart.fxml");
    }


}
