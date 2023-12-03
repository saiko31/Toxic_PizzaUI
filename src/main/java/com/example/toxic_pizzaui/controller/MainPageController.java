package com.example.toxic_pizzaui.controller;

import com.example.toxic_pizzaui.DataHandling.OrderController;
import com.example.toxic_pizzaui.Tp_Utils;
import com.example.toxic_pizzaui.objects.Order;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainPageController implements Initializable {

    @FXML
    private AnchorPane menuGrid;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(0), event -> Tp_Utils.loadFxml(menuGrid, "crustGrid.fxml")),
                new KeyFrame(Duration.seconds(4), event -> Tp_Utils.loadFxml(menuGrid, "toppingsGrid.fxml")),
                new KeyFrame(Duration.seconds(8), event -> Tp_Utils.loadFxml(menuGrid,"BeveragesGrid.fxml")),
                new KeyFrame(Duration.seconds(12))

        );

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        AppBarController.getInstance().setCartBtn(false);
        AppBarController.getInstance().setProfileBtn(false);

    }


    @FXML
    public void btnCrust(ActionEvent event) throws IOException {
        Tp_Utils.loadFxml(menuGrid, "crustGrid.fxml");
    }


    @FXML
    public void btnToppings(ActionEvent event) throws IOException {
        Tp_Utils.loadFxml(menuGrid, "toppingsGrid.fxml");
    }

    @FXML
    public void btnBeverages(ActionEvent event) throws IOException {
        Tp_Utils.loadFxml(menuGrid, "BeveragesGrid.fxml");
    }


    @FXML
    private void startOrder(ActionEvent e) throws IOException {
        //CREATES AN NEW ORDER OBJECT, DISABLES THE "SEE PROFILE BUTTON", AND JUMPS TO THE NEXT SCREEN
        OrderController.startNewOrder();
        AppBarController.getInstance().changeScreen("deliveryOptionPage.fxml");
        AppBarController.getInstance().setProfileBtn(true);
    }

}
