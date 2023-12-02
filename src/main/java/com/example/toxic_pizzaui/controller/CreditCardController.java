package com.example.toxic_pizzaui.controller;

import com.example.toxic_pizzaui.Tp_Utils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;
import java.util.regex.Pattern;

public class CreditCardController implements Initializable {
    @FXML
    private TextField CCV_field;

    @FXML
    private TextField cardNameField;

    @FXML
    private TextField cardNumberField;

    @FXML
    private Button confirmButton;

    @FXML
    private TextField expDateField;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        CCV_field.setTextFormatter(createNumericTextFormatter(3));
        cardNumberField.setTextFormatter(createNumericTextFormatter(16));
        expDateField.setTextFormatter(createNumericTextFormatter(4));
    }



    //Makes certain textfield to allows only numbers and limits text length
    private TextFormatter<String> createNumericTextFormatter(int maxLength) {
        UnaryOperator<TextFormatter.Change> filter = change -> {
            String newText = change.getControlNewText();

            // allows only numbers
            if (Pattern.matches("[0-9]*", newText) && newText.length() <= maxLength) {
                return change;
            } else {
                return null;
            }
        };
        return new TextFormatter<>(filter);
    }


    private boolean areFieldValid(){
        return !CCV_field.getText().isEmpty() &&
                CCV_field.getText().length() == 3 &&
                !cardNameField.getText().isEmpty() &&
                !cardNumberField.getText().isEmpty() &&
                cardNumberField.getText().length() == 16 &&
                !expDateField.getText().isEmpty() &&
                expDateField.getText().length() == 4;
    }

    @FXML
    private void confirm(){
        if(areFieldValid()){

        }
        else{
            Tp_Utils.showMessage("ERROR", "Please make sure the information is correct" );
        }
    }



}
