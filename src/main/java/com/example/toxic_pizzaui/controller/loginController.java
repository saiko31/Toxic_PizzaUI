package com.example.toxic_pizzaui.controller;

import com.example.toxic_pizzaui.Tp_Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;


import java.io.IOException;

public class loginController {
    @FXML
    private Label messageLabel;
    @FXML
    private  Pane messagePane;

    @FXML
    private PasswordField PASS_FIELD;

    @FXML
    private TextField PHONE_NUM_FIELD;





    @FXML
    private void signUp(ActionEvent e) throws IOException{                      //This will jump to the SignUp page in case the user wants to create a new account
        Tp_Utils.changeScene(e, "signUp.fxml");                         // Employee accounts will be registered by the manager, who will have a default login credentials, for now just leave it as *phoneNUM = admin and password = admin* for simplicity
    }

    @FXML
    private void login(ActionEvent event) throws IOException {
        if(PHONE_NUM_FIELD.getText().isBlank() == false && PASS_FIELD.getText().isBlank() == false){
            Tp_Utils.changeScene(event, "root.fxml");
        }
        else{                                                                           /*This will display a message on the screen asking for*/
            messagePane.setVisible(true);                                               /*the password and the phone number in case nothing is typed in the log in page */
            messageLabel.setText("Please enter username and password");
        }
    }

}