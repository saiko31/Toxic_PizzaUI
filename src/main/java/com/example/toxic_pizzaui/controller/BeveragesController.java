package com.example.toxic_pizzaui.controller;

import com.example.toxic_pizzaui.DataHandling.OrderController;
import com.example.toxic_pizzaui.Tp_Utils;
import com.example.toxic_pizzaui.objects.Beverages;
import com.example.toxic_pizzaui.objects.Order;
import com.example.toxic_pizzaui.objects.Pizza;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;


import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class BeveragesController implements Initializable {
    @FXML
    private ToggleGroup drinkFlavor;

    @FXML
    private ToggleGroup drinkSize;

    @FXML
    private AnchorPane pizzaPane;

    @FXML
    private Label priceLabel;

    private Beverages newBeverage;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        List<Pizza> pizzaList = OrderController.getOrder().getPizzaList();

        Tp_Utils.loadFxml(pizzaList.get(pizzaList.size() - 1), pizzaPane);

        newBeverage = new Beverages();
    }

    @FXML
    private void continueShopping(ActionEvent e) throws IOException {
        AppBarController.getInstance().changeScreen("pizzaCreation.fxml");
    }

    @FXML
    private void selectBeverageSize(){
        ToggleButton selected = (ToggleButton) drinkSize.getSelectedToggle();

        if(selected != null){
            newBeverage.setSize(selected.getAccessibleText().toLowerCase());
            setPriceLabel();
        }
    }

    @FXML
    private void selectFlavor(){
        ToggleButton selected = (ToggleButton) drinkFlavor.getSelectedToggle();

        if(selected != null){
            newBeverage.setDrink(selected.getAccessibleText());
        }

    }

    @FXML
    private void addToCart(){
        if(newBeverage.getSize() == null || newBeverage.getSize() == null && newBeverage.getSize().equals("")){
            //GENERATE A MESSAGE WINDOW "PLEASE SELECT A DRINK SIZE AND A FLAVOR"

        }else{
            OrderController.getOrder().addBeverageToCart(newBeverage);
            Tp_Utils.loadFxml(newBeverage, pizzaPane);
        }
    }

    @FXML
    private void clear(){
        Tp_Utils.deselectAllToggles(drinkFlavor);
        Tp_Utils.deselectAllToggles(drinkSize);

        newBeverage.clear();
        setPriceLabel();
    }



    private void setPriceLabel(){priceLabel.setText("$" + newBeverage.getPrice());}

    @FXML
    private void goToCheckout(){
       AppBarController.getInstance().changeScreen("checkout.fxml");
    }


}
