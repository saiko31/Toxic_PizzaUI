package com.example.toxic_pizzaui.objects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pizza {

    private float price;

    private final List<Topping> toppings;

    private Crust crustOption;

    private String size;

    private static final Map<String, Float> PIZZA_SIZE = new HashMap<>();

    static{
        PIZZA_SIZE.put("none", 0f);
        PIZZA_SIZE.put("small", 8.99f);
        PIZZA_SIZE.put("medium", 11.99f);
        PIZZA_SIZE.put("large", 14.99f);
        PIZZA_SIZE.put("family", 17.99f);
    }


    public Pizza (){
        price = 0;
        this.toppings = new ArrayList<>();
    }


    public void addTopping(Topping toppingOption){
        toppings.add(toppingOption);
    }

    public void setCrustOption(Crust crust){
        crustOption = crust;
    }

    public void setPizzaSize(String size){
        this.size = size;
    }

    public float getPrice(){
        float sizePrice = PIZZA_SIZE.getOrDefault(size.toLowerCase(), 0f);
        float crustPrice = crustOption != null? crustOption.getPrice() : 0f;
        float toppingsPrice = 0;

        for(Topping i: toppings){
            toppingsPrice =+ i.getPrice();
        }



        return sizePrice + crustPrice + toppingsPrice;
    }

    public int getToppings(){                   // RETURNS TOPPING LIST SIZE
        return toppings.size();
    }

    public void clear(){
        toppings.clear();
        setPizzaSize("none");
        setCrustOption(new Crust("none"));
    }





}
