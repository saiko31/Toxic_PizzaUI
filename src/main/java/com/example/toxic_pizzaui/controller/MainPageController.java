package com.example.toxic_pizzaui.controller;

import com.example.toxic_pizzaui.objects.Tp_Utils;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class MainPageController {
    @FXML
    private AnchorPane beveragesMenu;

    @FXML
    private AnchorPane crustMenu;

    @FXML
    private AnchorPane toppingsMenu;

    private final FadeTransition fadeTransition;
    private Timeline menuTimeLine;


    public MainPageController(){
        fadeTransition  =new FadeTransition(Duration.millis(700));
        fadeTransition.setFromValue(0.0);
        fadeTransition.setToValue(1.0);

        menuTimeLine = new Timeline(
                new KeyFrame(Duration.seconds(0), event -> switchMenu(crustMenu)),
                new KeyFrame(Duration.seconds(5), event -> switchMenu(toppingsMenu)),
                new KeyFrame(Duration.seconds(10), event -> switchMenu(beveragesMenu))
                );
        menuTimeLine.setCycleCount(Timeline.INDEFINITE);
        menuTimeLine.play();
    }
    @FXML
    public void btnCrust(ActionEvent event) throws IOException{
      switchMenu(crustMenu);
      restartTimeLine();

    }
    @FXML
    public void btnToppings(ActionEvent event) throws IOException{
        switchMenu(toppingsMenu);
        restartTimeLine();
    }

    @FXML
    public void btnBeverages(ActionEvent event) throws  IOException{
        switchMenu(beveragesMenu);
        restartTimeLine();
    }



    @FXML
    private void startOrder(ActionEvent e) throws IOException{                      /// Press the "Start Order Button", will jump to the order type selection page
        Tp_Utils.changeScene(e, "deliveryOptionPage.fxml");
    }




    @FXML
    private void switchMenu(AnchorPane targetMenu){                                 // This is suppose to be a animation for the menu to disp


        beveragesMenu.setVisible(false);
        toppingsMenu.setVisible(false);
        beveragesMenu.setVisible(false);

       targetMenu.setVisible(true);
    }

    private void restartTimeLine(){
        menuTimeLine.stop();
        menuTimeLine.playFromStart();
    }



}
