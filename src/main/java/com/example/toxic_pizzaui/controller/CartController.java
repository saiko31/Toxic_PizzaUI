package com.example.toxic_pizzaui.controller;

import com.example.toxic_pizzaui.DataHandling.OrderController;
import com.example.toxic_pizzaui.Tp_Utils;
import com.example.toxic_pizzaui.objects.Beverages;
import com.example.toxic_pizzaui.objects.Crust;
import com.example.toxic_pizzaui.objects.Order;
import com.example.toxic_pizzaui.objects.Pizza;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CartController implements Initializable {

    private static CartController instance;

    @FXML
    private VBox itemsList;

    @FXML
    private Button checkoutBtn;

    @FXML
    private Pane sidePane;

    private List<Pizza> pizzaList;

    private List<Beverages> beveragesList;
    public CartController() {
        instance = this;
    }

    @FXML
    public void goBack() {
        AppBarController.getInstance().closeCart();
    }

    @FXML
    public void goToCheckout() {
    }

    public static CartController getInstance() {
        return instance;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        if(OrderController.getOrder() != null){
            pizzaList = OrderController.getOrder().getPizzaList();
            beveragesList = OrderController.getOrder().getBeveragesList();


            if(pizzaList.size() > 0){
                for (Pizza pizza : pizzaList) {
                    Tp_Utils.addedToCart(pizza, itemsList);
                }
            }
            else if(beveragesList.size() > 0){
                for(Beverages beverage: beveragesList){
                    Tp_Utils.addedToCart(beverage, itemsList);
                }
            }
            else{
                if (itemsList.contains(null)) {
                    checkoutBtn.setDisable(false);
                }
            }
        }

    }

    private void createSamplePizza() {
        Pizza pizza1 = new Pizza();
        pizza1.setPizzaSize("small");
        pizza1.setCrustOption(new Crust("deep"));
        pizzaList.add(pizza1);
    }
}

