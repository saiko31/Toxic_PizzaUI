package com.example.toxic_pizzaui.controller;

import com.example.toxic_pizzaui.DataHandling.OrderController;
import com.example.toxic_pizzaui.Tp_Utils;
import com.example.toxic_pizzaui.objects.Order;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

import java.io.IOException;

public class MainPageController{

    private Order order;


    @FXML
    public void btnCrust(ActionEvent event) throws IOException{
        Tp_Utils.showMessage("TEST", "This is a Test");
    }


    @FXML
    public void btnToppings(ActionEvent event) throws IOException{

    }

    @FXML
    public void btnBeverages(ActionEvent event) throws  IOException{
    }



    @FXML
    private void startOrder(ActionEvent e) throws IOException{
       //CREATES AN NEW ORDER OBJECT, DISABLES THE "SEE PROFILE BUTTON", AND JUMPS TO THE NEXT SCREEN
        OrderController.startNewOrder();
        AppBarController.getInstance().changeScreen("deliveryOptionPage.fxml");
        AppBarController.getInstance().setProfileBtn(true);
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
