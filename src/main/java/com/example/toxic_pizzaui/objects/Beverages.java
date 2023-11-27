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

    public String getDrink() {
        return drink;
    }

    public float getPrice() {
        return price;
    }

    public Beverages(String size, String flavor){
        this.size = size;
        price = SIZE.getOrDefault(size.toLowerCase(), 0f);
        this.drink = flavor;
    }


}
