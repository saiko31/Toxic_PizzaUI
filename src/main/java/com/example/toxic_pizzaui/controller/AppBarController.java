
package com.example.toxic_pizzaui.controller;


import com.example.toxic_pizzaui.Tp_Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;




public class AppBarController implements Initializable {

    @FXML
    private AnchorPane screen;

    @FXML
    private AnchorPane cartPane;

    @FXML
    private Button profileBtn;

    private static AppBarController instance;

    private AnchorPane newPane;




    public AppBarController(){
        instance = this;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        changeScreen("MainPage.fxml");
    }


    @FXML
    private void seeProfile(ActionEvent e){
        Tp_Utils.changeScene(e, "userProfile.fxml");
    }

    @FXML
    public void goToCart(ActionEvent event) throws IOException {
        cartPane.setDisable(false);

        try{
            FXMLLoader loader = new FXMLLoader(Tp_Utils.class.getResource("/com/example/toxic_pizzaui/.fxml/cart.fxml"));
            newPane  = loader.load();
            cartPane.getChildren().add(newPane);

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void setProfileBtn(Boolean active){
        profileBtn.setDisable(active);             // false = activate ; true = deactivate
    }


    public void closeCart(){
        cartPane.setDisable(true);
        cartPane.getChildren().remove(newPane);
    }


    public void changeScreen(String fxmlFile){
        try{
            FXMLLoader loader = new FXMLLoader(Tp_Utils.class.getResource("/com/example/toxic_pizzaui/.fxml/" + fxmlFile));
            AnchorPane newPane  = loader.load();

            screen.getChildren().setAll(newPane);

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public AnchorPane getCartPane(){
        return cartPane;
    }

    public static AppBarController getInstance(){
        return instance;
    }



}
