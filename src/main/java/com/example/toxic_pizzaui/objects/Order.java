package com.example.toxic_pizzaui.objects;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<Pizza> pizzaList;

    private List<Beverages> beveragesList;

    private String deliveryOption;

    private float price;

    private Customer customer;
    private static int currentOrder = 100000000;


    public Order(){
        currentOrder++;
        pizzaList = new ArrayList<>();
        beveragesList = new ArrayList<>();
    }

    public void addPizzaToCart(Pizza pizza){
        pizzaList.add(pizza);
    }
    public void addBeverageToCart(Beverages beverages){
        beveragesList.add(beverages);
    }

    public void setDeliveryOption(String delivery){
        this.deliveryOption = delivery;
    }

    public float getPrice(){
        float pizzasPrice = 0f;
        float drinksPrice = 0f;

        if(!pizzaList.isEmpty() && !beveragesList.isEmpty()) {
            for (Beverages i : beveragesList) {
                drinksPrice = +i.getPrice();
            }
            for (Pizza i : pizzaList) {
                pizzasPrice = +i.getPrice();
            }
        }
        return pizzasPrice + drinksPrice;
    }

    public List<Pizza> getPizzaList() {
        return pizzaList;
    }

    public List<Beverages> getBeveragesList() {
        return beveragesList;
    }

    public String getDeliveryOption(){
        return deliveryOption;
    }

    public void removePizza(Pizza removedPizza){
        pizzaList.remove(removedPizza);
    }
    public void removeBeverage(Beverages removedBeverage){
        beveragesList.remove(removedBeverage);
    }



}
