package com.example.toxic_pizzaui;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.DecimalFormat;

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


    public static void deselectAllToggles (ToggleGroup toggleGroup){
        toggleGroup.getToggles().forEach(toggle -> {
            if(toggle.isSelected()){toggle.setSelected(false);}
        });
    }

    public float roundPrices(float price){
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String roundedValueString = decimalFormat.format(price);

        return Float.parseFloat(roundedValueString);
    }



}
