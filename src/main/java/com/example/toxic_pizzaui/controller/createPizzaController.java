package com.example.toxic_pizzaui.controller;


import com.example.toxic_pizzaui.DataHandling.OrderController;
import com.example.toxic_pizzaui.objects.Crust;
import com.example.toxic_pizzaui.objects.Order;
import com.example.toxic_pizzaui.objects.Pizza;
import com.example.toxic_pizzaui.objects.Topping;
import com.example.toxic_pizzaui.Tp_Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class createPizzaController implements Initializable {


    @FXML
    private Label priceLabel;

    @FXML
    private ToggleGroup toppingsBtn;

    @FXML
    private ToggleGroup pizzaSizes;

    @FXML
    private ToggleGroup crustBtn;

    @FXML
    private Label toppingsCounter;

    private Pizza newPizza;

    private Order order;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        newPizza = new Pizza();
    }



    @FXML
    private void backBtn(ActionEvent e) throws IOException{
        AppBarController.getInstance().changeScreen("deliveryOptionPage.fxml");
    }

    @FXML
    private void selectPizzaSize(ActionEvent e){
        ToggleButton selected = (ToggleButton) pizzaSizes.getSelectedToggle();

        if(selected != null){
            newPizza.setPizzaSize(selected.getAccessibleText().toLowerCase());
            setLabelPrice();
        }
    }

    @FXML
    private void selectPizzaCrust(ActionEvent e){
        ToggleButton selected = (ToggleButton) crustBtn.getSelectedToggle();

        if(selected != null){
            newPizza.setCrustOption(new Crust(selected.getAccessibleText().toLowerCase()));
            setLabelPrice();
        }

    }
    @FXML
    private void selectToppings(ActionEvent e){

        if(newPizza.getToppingsNumbers() <=3){
            ToggleButton selected = (ToggleButton) toppingsBtn.getSelectedToggle();
            if(selected != null){
                newPizza.addTopping(new Topping(selected.getAccessibleText().toLowerCase()));
            }
            toppingsCounter.setText(newPizza.getToppingsNumbers() + " out of 4");
            setLabelPrice();
        }

    }

    @FXML

    private void clear(){                               //Clears all selections made by user
        Tp_Utils.deselectAllToggles(pizzaSizes);
        Tp_Utils.deselectAllToggles(crustBtn);
        Tp_Utils.deselectAllToggles(toppingsBtn);

        newPizza.clear();
        toppingsCounter.setText(newPizza.getToppingsNumbers() + " out of 4");
        setLabelPrice();
    }



    private void setLabelPrice(){                        //Updates the price tag
        priceLabel.setText("$" + newPizza.getPrice());
    }

    @FXML
    private void addPizzaToCart(){
        if(newPizza.getSize() == null || newPizza.getCrustOption() == null){
            //GENERATE A MESSAGE WINDOW "PLEASE SELECT A PIZZA SIZE AND AT LEAST ONE CRUST"
            Tp_Utils.showMessage("ERROR", "Please select a pizza size and at least one crust");
        }
        else{
            //ADDS THE PIZZA TO THE ORDER AND JUMP TO THE NEXT SCREEN
            OrderController.getOrder().addPizzaToCart(newPizza);
            AppBarController.getInstance().changeScreen("drinksPage.fxml");
        }
    }
}
