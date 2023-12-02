package com.example.toxic_pizzaui.controller;

import com.example.toxic_pizzaui.DataHandling.OrderController;
import com.example.toxic_pizzaui.Tp_Utils;
import com.example.toxic_pizzaui.objects.Beverages;
import com.example.toxic_pizzaui.objects.Pizza;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
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

    @FXML
    private AnchorPane paymentInfo;

    @FXML
    private ToggleButton cashOption;

    private List<Pizza> pizzaList;

    private List<Beverages> beveragesList;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pizzaList = OrderController.getOrder().getPizzaList();
        beveragesList = OrderController.getOrder().getBeveragesList();

        //Displays cart content

        if (pizzaList.size() > 0) {
            for (Pizza pizza : pizzaList) {
                Tp_Utils.addedToCart(pizza, orderList);
            }
            if (beveragesList.size() > 0) {
                for (Beverages beverage : beveragesList) {
                    Tp_Utils.addedToCart(beverage, orderList);
                }
            }
        }

        //Sets the final price and shows the delivery option selected previously

        float totalPrice = setPriceLabel();
        FINAl_PRICE_LABEL.setText("$" + Tp_Utils.roundPrices(totalPrice));

        String deliveryOption = OrderController.getOrder().getDeliveryOption();
        DELIVERY_OPTION.setText(deliveryOption != null ? deliveryOption : "No Delivery Option");

        // If the order is store pick up, disable cash option
        if (!"In-Store Pickup".equalsIgnoreCase(deliveryOption)) {
            cashOption.setDisable(false);
        } else {
            cashOption.setText("Cash | Delivery Only");
            cashOption.setStyle("-fx-font-size: 12px;");
            cashOption.setDisable(true);
        }
    }



    private float setPriceLabel(){
        return Tp_Utils.roundPrices(OrderController.getOrder().getPrice());
    }


    //PAYMENT OPTIONS
    public void selectPaymentOption(){
        ToggleButton selected = (ToggleButton) paymentOptions.getSelectedToggle();
        if(selected != null){
            //Sets the order payment option
            OrderController.getOrder().setPaymentOption(selected.getAccessibleText());
            //Enables the payment form
            switch (selected.getAccessibleText()){
                case "Debit / Credit Card" -> Tp_Utils.loadFxml(paymentInfo, "creditCard.fxml");
                case "Check" -> Tp_Utils.loadFxml(paymentInfo, "checkPayment.fxml");
                case "Cash" -> Tp_Utils.loadFxml(paymentInfo, "cashPayment.fxml");
            }
        }
    }

    @FXML
    public void placeOrder(){
        AppBarController.getInstance().changeScreen("orderComplete.fxml");
    }




}
