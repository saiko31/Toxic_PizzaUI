package com.example.toxic_pizzaui.controller;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class cartController {


    private static cartController instance;

    @FXML
    private VBox itemsList;

    @FXML
    private Button checkoutBtn;

    @FXML
    private Pane sidePane;


    public cartController(){
        instance = this;
    }


    @FXML
    public void goBack(){
        AppBarController.getInstance().closeCart();

    }

    @FXML
    public void goToCheckout(){
        if(itemsList.contains(null)){
            checkoutBtn.setDisable(false);
        }
    }

    public void cartAnimation(){
        sidePane.setTranslateX(sidePane.getWidth());

        TranslateTransition transition = new TranslateTransition(Duration.seconds(0.5), sidePane);
        transition.setToX(0);
        transition.play();
    }

    public static cartController getInstance(){
        return instance;
    }


}
