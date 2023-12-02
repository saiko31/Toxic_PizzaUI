package com.example.toxic_pizzaui;

import com.example.toxic_pizzaui.controller.AddedToCartController;
import com.example.toxic_pizzaui.controller.AppBarController;
import com.example.toxic_pizzaui.controller.MessageController;
import com.example.toxic_pizzaui.objects.Beverages;
import com.example.toxic_pizzaui.objects.Pizza;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
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

    public static  float roundPrices(float price){
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String roundedValueString = decimalFormat.format(price);

        return Float.parseFloat(roundedValueString);
    }

    public static void addedToCart(Pizza pizza, VBox location){
        try {
            FXMLLoader loader = new FXMLLoader(Tp_Utils.class.getResource("/com/example/toxic_pizzaui/.fxml/AddedToCartPane.fxml"));
            AnchorPane pane = loader.load();
            AddedToCartController controller = loader.getController();
            controller.setData(pizza);
            location.getChildren().add(pane);
        }catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void addedToCart(Beverages beverages, VBox location) {
        try {
            FXMLLoader loader = new FXMLLoader(Tp_Utils.class.getResource("/com/example/toxic_pizzaui/.fxml/AddedToCartPane.fxml"));
            AnchorPane pane = loader.load();
            AddedToCartController controller = loader.getController();
            controller.setData(beverages);
            location.getChildren().add(pane);
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
    }

    public static void loadFxml(Beverages beverages, AnchorPane location) {
        location.getChildren().clear();
        try {
            FXMLLoader loader = new FXMLLoader(Tp_Utils.class.getResource("/com/example/toxic_pizzaui/.fxml/AddedToCartPane.fxml"));
            AnchorPane pane = loader.load();
            AddedToCartController controller = loader.getController();
            controller.setData(beverages);
            location.getChildren().add(pane);
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
    }

    public static void loadFxml(Pizza pizza, AnchorPane location) {
        location.getChildren().clear();
        try {
            FXMLLoader loader = new FXMLLoader(Tp_Utils.class.getResource("/com/example/toxic_pizzaui/.fxml/AddedToCartPane.fxml"));
            AnchorPane pane = loader.load();
            AddedToCartController controller = loader.getController();
            controller.setData(pizza);
            location.getChildren().add(pane);
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
    }

    /*The following methods are for load fxml file where necessary and being able to remove them*/

    private static AnchorPane loadedPane;

    public static void loadFxml(AnchorPane location, String fxmlFile) {
        location.getChildren().clear();
        try {
            FXMLLoader loader = new FXMLLoader(Tp_Utils.class.getResource("/com/example/toxic_pizzaui/.fxml/" + fxmlFile));
            loadedPane = loader.load();
            location.getChildren().add(loadedPane);
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
    }


    /*The following methods are used to show a message at the center of the screen*/

    private static AnchorPane newPane;
    private static AnchorPane messagePane;


    public static void showMessage(String messageHeader, String message){
        newPane = AppBarController.getInstance().getCartPane();
        newPane.setDisable(false);

        try{
            FXMLLoader loader = new FXMLLoader(Tp_Utils.class.getResource("/com/example/toxic_pizzaui/.fxml/messagePopUp.fxml"));
            messagePane = loader.load();

            AnchorPane.setTopAnchor(messagePane, 0.0);
            AnchorPane.setBottomAnchor(messagePane, 0.0);
            AnchorPane.setLeftAnchor(messagePane, 0.0);
            AnchorPane.setRightAnchor(messagePane, 0.0);

            MessageController messageController = loader.getController();

            messageController.setMessage(messageHeader, message);

            newPane.getChildren().add(messagePane);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void closeMessage(){
        newPane = AppBarController.getInstance().getCartPane();
        newPane.setDisable(true);
        newPane.getChildren().remove(messagePane);
    }










}
