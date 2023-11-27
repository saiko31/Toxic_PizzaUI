package com.example.toxic_pizzaui.objects;

import java.util.HashMap;
import java.util.Map;

public class Crust {

    private static final Map<String, Float> CRUST = new HashMap<>();


    static {
        CRUST.put("none", 0f);
        CRUST.put("thin", 0.99f);
        CRUST.put("stuffed", 1.49f);
        CRUST.put("deep", 1.99f);
    }


    private final String description;
    private float price;

    public Crust(String description){
        this.description = description;
        this.price = CRUST.getOrDefault(description.toLowerCase(), 0f);
    }

    public String getDescription() {
        return description;
    }

    public float getPrice() {
        return price;
    }
}
