package com.example.toxic_pizzaui.controller;

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
                new KeyFrame(Duration.seconds(10), event -> {
                    switchMenu(beveragesMenu);
                    /*menuTimeLine.playFromStart();*/})
                );
        menuTimeLine.setCycleCount(Timeline.INDEFINITE);
        menuTimeLine.play();
    }

    public void btnCrust(ActionEvent event) throws IOException{
      switchMenu(crustMenu);
      restartTimeLine();

    }

    public void btnToppings(ActionEvent event) throws IOException{
        switchMenu(toppingsMenu);
        restartTimeLine();
    }
    public void btnBeverages(ActionEvent event) throws  IOException{
        switchMenu(beveragesMenu);
        /*restartTimeLine();*/
        System.out.println("beverages");
    }


    private void switchMenu(AnchorPane targetMenu){
        fadeTransition.setNode(targetMenu);
        fadeTransition.play();
        fadeTransition.setOnFinished(event -> {
            crustMenu.setVisible(false);
            toppingsMenu.setVisible(false);
            beveragesMenu.setVisible(false);

            targetMenu.setOpacity(1.0);
            targetMenu.setVisible(true);
        });

    }

    private void restartTimeLine(){
        menuTimeLine.stop();
        menuTimeLine.playFromStart();
    }

}
