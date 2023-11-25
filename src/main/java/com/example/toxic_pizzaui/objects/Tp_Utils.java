package com.example.toxic_pizzaui.objects;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Tp_Utils {

    public static void changeScene(ActionEvent event, String fxmlFile){

        Parent root =null;


        try{
            FXMLLoader loader = new FXMLLoader(Tp_Utils.class.getResource("/com/example/toxic_pizzaui/.fxml/" + fxmlFile));
            root = loader.load();

        }catch (IOException e){
            e.printStackTrace();
        }

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }



    public static void signUpUser(ActionEvent event, String phoneNumber, String password){
        Connection connection = null;
        PreparedStatement psInsert = null;
        PreparedStatement psCheckUserExist = null;
        ResultSet resultSet = null;
    }


}
