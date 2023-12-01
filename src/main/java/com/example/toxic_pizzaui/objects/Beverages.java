package com.example.toxic_pizzaui.objects;

import java.util.HashMap;
import java.util.Map;

public class Beverages {

    private String size;
    private String drink;
    private float price;


    private static final Map<String, Float> SIZE= new HashMap<>();

    static{
        SIZE.put("none", 0f);
        SIZE.put("small", 1.99f);
        SIZE.put("medium", 2.49f);
        SIZE.put("large", 2.49f);
    }

    public String getSize() {
        return size;
    }

    public String getDrink(){
        return this.drink;
    }

    public String printSize() {
        return switch (size) {
            case "small" -> "Small Drink";
            case "medium" -> "Medium Drink";
            case "large" -> "Large Drink";
            default -> "";
        };
    }

    public String setImage(){
        return switch (drink){
            case "Coca-Cola" -> "cocaCola.png";
            case "Sprite" -> "sprite.jpg";
            case "Mountain Dew" -> "mDew.jpg";
            case "Lemonade" -> "lemonade.jpeg";
            case "Pepsi" -> "pepsi.jpg";
            default -> "userIcon_yellow.png";
        };
    }

    public float getPrice() {
        return SIZE.getOrDefault(size.toLowerCase(), 0f);
    }


    public void setDrink(String drink) {
        this.drink = drink;
    }
    public void setSize(String size){
        this.size = size;
    }

    public void clear(){
        setSize("none");
        setDrink(null);
    }

    public Beverages(){
        this.price = 0.00f;
    }
}
