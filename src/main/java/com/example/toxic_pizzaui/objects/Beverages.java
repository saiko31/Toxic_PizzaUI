package com.example.toxic_pizzaui.objects;

import java.util.HashMap;
import java.util.Map;

public class Beverages {

    private String size;
    private String drink;
    private float price;


    private static final Map<String, Float> SIZE= new HashMap<>();

    static{
        SIZE.put("small", 1.99f);
        SIZE.put("medium", 2.49f);
        SIZE.put("large", 2.49f);
    }

    public String getSize() {
        return size;
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




    public Beverages(){
        this.price = 0.00f;
    }
}
