package com.example.toxic_pizzaui.controller;

import com.example.toxic_pizzaui.DataHandling.OrderController;
import com.example.toxic_pizzaui.Tp_Utils;
import com.example.toxic_pizzaui.objects.Beverages;
import com.example.toxic_pizzaui.objects.Order;
import com.example.toxic_pizzaui.objects.Pizza;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class CheckoutController implements Initializable {

    @FXML
    private Label CUSTOMER_ADDRESS;

    @FXML
    private Label CUSTOMER_NAME;

    @FXML
    private Label DELIVERY_OPTION;

    @FXML
    private ToggleGroup paymentOptions;

    @FXML
    private VBox orderList;

    @FXML
    private Label FINAl_PRICE_LABEL;

    private List<Pizza> pizzaList;

    private List<Beverages> beveragesList;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pizzaList = OrderController.getOrder().getPizzaList();
        beveragesList = OrderController.getOrder().getBeveragesList();

        if(pizzaList.size() > 0){
            for (Pizza pizza : pizzaList) {
                Tp_Utils.addedToCart(pizza, orderList);
            }
            if(beveragesList.size() > 0){
                for(Beverages beverage: beveragesList){
                    Tp_Utils.addedToCart(beverage, orderList);
                }
            }
        }

        FINAl_PRICE_LABEL.setText("$" + OrderController.getOrder().getPrice());

        DELIVERY_OPTION.setText(OrderController.getOrder().getDeliveryOption());

    }





}
