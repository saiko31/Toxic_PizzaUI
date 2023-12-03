package com.example.toxic_pizzaui.controller;

import com.example.toxic_pizzaui.DataHandling.OrderController;
import com.example.toxic_pizzaui.Tp_Utils;
import com.example.toxic_pizzaui.objects.Beverages;
import com.example.toxic_pizzaui.objects.Order;
import com.example.toxic_pizzaui.objects.Pizza;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.time.LocalTime;
import java.util.List;
import java.util.ResourceBundle;

public class OrderProcessedController implements Initializable {

    @FXML
    private Label finalPrice;

    @FXML
    private Label hour;

    @FXML
    private VBox orderItems;

    @FXML
    private Label orderNumber;

    @FXML
    private Label paymentType;

    private List<Pizza> pizzaList;

    private List<Beverages> beveragesList;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        pizzaList = OrderController.getOrder().getPizzaList();
        beveragesList = OrderController.getOrder().getBeveragesList();

        //Displays cart content

        if (pizzaList.size() > 0) {
            for (Pizza pizza : pizzaList) {
                Tp_Utils.addedToCart(pizza, orderItems);
            }
            if (beveragesList.size() > 0) {
                for (Beverages beverage : beveragesList) {
                    Tp_Utils.addedToCart(beverage, orderItems);
                }
            }
        }

        finalPrice.setText("$" + setPriceLabel());
        paymentType.setText(OrderController.getOrder().getPaymentOption());
        hour.setText(String.valueOf(LocalTime.now()));



    }



    private float setPriceLabel(){
        return Tp_Utils.roundPrices(OrderController.getOrder().getPrice());
    }

    @FXML
    public void goToMainMenu(){
        AppBarController.getInstance().changeScreen("MainPage.fxml");
    }

    public void printReceipt(){

    }


}
