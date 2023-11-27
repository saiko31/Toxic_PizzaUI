package com.example.toxic_pizzaui.controller;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class profileController extends Application {
    Button userButton;
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("User Profile");
        userButton = new Button();
        userButton.setText("Profile");
        StackPane userLayout = new StackPane();
        userLayout.getChildren().add(userButton);

        Scene userScene = new Scene(userLayout, 1280, 800);
        stage.setScene(userScene);
        stage.show();
    }
}
