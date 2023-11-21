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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/toxic_pizzaui/.fxml/MainPage.fxml"));
        Parent root = loader.load();




        //Adding a window pizza icon
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/com/example/toxic_pizzaui/.style/pizza-win-icon.png")));

        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.setTitle("Toxic Pizza");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}