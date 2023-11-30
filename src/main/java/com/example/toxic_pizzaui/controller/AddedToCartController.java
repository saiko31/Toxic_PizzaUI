package com.example.toxic_pizzaui.controller;

import com.example.toxic_pizzaui.objects.Beverages;
import com.example.toxic_pizzaui.objects.Pizza;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class AddedToCartController {

    @FXML
    private Label SIZE_label;

    @FXML
    private Text DESCRIPTION_label;

    @FXML
    private ImageView itemImage;

    public void setData(Pizza pizza) {
        setPizzaImage(pizza);
        SIZE_label.setText(pizza.printSize());
        DESCRIPTION_label.setText(pizza.printDescription());
    }

    public void setData(Beverages beverage) {
        setBeverageImage(beverage);
        SIZE_label.setText(beverage.printSize());
        DESCRIPTION_label.setText(beverage.getDrink());
    }

    private void setPizzaImage(Pizza pizza) {
        String imagePath = "/com/example/toxic_pizzaui/.style/" + pizza.setImage();
        Image image = new Image(getClass().getResourceAsStream(imagePath));
        itemImage.setImage(image);
    }

    private void setBeverageImage(Beverages beverage) {
        String imagePath = "/com/example/toxic_pizzaui/.style/" + beverage.setImage();
        Image image = new Image(getClass().getResourceAsStream(imagePath));
        itemImage.setImage(image);
    }
}

