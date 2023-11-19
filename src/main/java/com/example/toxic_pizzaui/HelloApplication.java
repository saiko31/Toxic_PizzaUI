package com.example.toxic_pizzaui;

import javafx.application.Application;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.image.Image;
import javafx.stage.*;


import java.io.IOException;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //Creating scene
        FXMLLoader login = new FXMLLoader(getClass().getResource("/com/example/toxic_pizzaui/.fxml/MainPage.fxml"));
        Scene scene = new Scene(login.load());
        //scene.getStylesheets().add("/com/example/toxic_pizzaui/.style/loginPage.css");


        //Adding a window pizza icon
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/com/example/toxic_pizzaui/.style/pizza-win-icon.png")));

        stage.setResizable(false);
        stage.setTitle("Toxic Pizza");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}