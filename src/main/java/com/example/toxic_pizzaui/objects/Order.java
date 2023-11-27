package com.example.toxic_pizzaui.objects;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<Pizza> pizzaList;

    private List<Beverages> beveragesList;

    private float price;


    public Order(){
        pizzaList = new ArrayList<>();
        beveragesList = new ArrayList<>();
    }

    public void addPizzaToCart(Pizza pizza){
        pizzaList.add(pizza);
    }
    public void addBeverageToCart(Beverages beverages){
        beveragesList.add(beverages);
    }


}
