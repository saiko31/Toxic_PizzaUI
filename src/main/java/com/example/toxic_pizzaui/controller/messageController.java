
package com.example.toxic_pizzaui.controller;

import com.example.toxic_pizzaui.Tp_Utils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class messageController{
    @FXML
    private Label message;

    @FXML
    private Label messageHeader;



    public messageController(){

    }

    @FXML
    public void setMessage(String messageHeader, String message){
        this.messageHeader.setText(messageHeader);
        this.message.setText(message);
    }

    @FXML
    private void close(){
        Tp_Utils.closeMessage();
    }


}
