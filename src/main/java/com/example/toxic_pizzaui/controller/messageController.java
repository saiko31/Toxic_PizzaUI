package com.example.toxic_pizzaui.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class messageController {
    @FXML
    private Label message;

    @FXML
    private Label messageHeader;



    @FXML
    public void setMessage(String messageHeader, String message){
        this.messageHeader.setText(messageHeader);
        this.message.setText(message);
    }



}
