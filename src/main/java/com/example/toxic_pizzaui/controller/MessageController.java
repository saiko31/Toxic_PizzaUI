
package com.example.toxic_pizzaui.controller;

import com.example.toxic_pizzaui.Tp_Utils;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MessageController {
    @FXML
    private Label message;

    @FXML
    private Label messageHeader;



    public MessageController(){

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
