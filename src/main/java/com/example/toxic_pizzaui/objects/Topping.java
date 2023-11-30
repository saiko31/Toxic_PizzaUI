package com.example.toxic_pizzaui.objects;

import java.util.HashMap;
import java.util.Map;

public class Topping {

    private static final Map<String, Float> toppings  = new HashMap<>();

    static {
        toppings.put("cheese", 0.99f);
        toppings.put("pepperoni", 1.49f);
        toppings.put("veggie", 1.99f);
        toppings.put("meat", 2.49f);
        toppings.put("threeCheese", 1.99f);
        toppings.put("bbq", 2.99f);
        toppings.put("ham", 1.79f);
        toppings.put("mushrooms", 1.29f);
    }

    private String description;
    private float price;

    public Topping(String description) {
        this.description = description;
        this.price = toppings.getOrDefault(description.toLowerCase(), 0f);
    }

    public String getDescription() {
        return switch (description){
            case "cheese" -> "Cheese";
            case "pepperoni" -> "Pepperoni";
            case "veggie" -> "Veggie";
            case "meat" -> "Meat";
            case "threeCheese" -> "3-Cheese";
            case "bbq" -> "BBQ-Chicken";
            case "ham" -> "Ham";
            case "mushrooms" -> "Mushrooms";
            default -> "";
        };
    }

    public float getPrice() {
        return price;
    }
}

