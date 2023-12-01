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

    static {
        PIZZA_SIZE.put("none", 0f);
        PIZZA_SIZE.put("small", 8.99f);
        PIZZA_SIZE.put("medium", 11.99f);
        PIZZA_SIZE.put("large", 14.99f);
        PIZZA_SIZE.put("family", 17.99f);
    }

    public Pizza() {
        price = 0;
        toppings = new ArrayList<>();
    }

    public void addTopping(Topping toppingOption) {
        toppings.add(toppingOption);
    }

    public void setCrustOption(Crust crust) {
        crustOption = crust;
    }

    public void setPizzaSize(String size) {
        this.size = size;
    }

    public float getPrice() {
        float sizePrice = PIZZA_SIZE.getOrDefault(size.toLowerCase(), 0f);
        float crustPrice = (crustOption != null) ? crustOption.getPrice() : 0f;
        float toppingsPrice = toppings.stream().map(Topping::getPrice).reduce(0f, Float::sum);

        return sizePrice + crustPrice + toppingsPrice;
    }

    public int getToppingsNumbers() {
        return toppings.size();
    }

    public String printToppings() {
        return toppings.stream().map(Topping::getDescription).reduce("", (str, desc) -> str + desc + "\n");
    }

    public String printDescription() {
        return crustOption.printDescription() + "\n" + printToppings();
    }

    public String printSize() {
        return switch (size) {
            case "small" -> "Small Pizza (10\")";
            case "medium" -> "Medium Pizza (12\")";
            case "large" -> "Large Pizza (14\")";
            case "family" -> "Family Pizza (16\")";
            default -> "";
        };
    }

    public Crust getCrustOption() {
        return crustOption;
    }

    public String getSize() {
        return size;
    }

    public void clear() {
        toppings.clear();
        setPizzaSize("none");
        setCrustOption(new Crust("none"));
    }

    public String setImage(){
        return switch (crustOption.getDescription()){
            case "thin" -> "Thin-Crust-PIzza-2.jpg";
            case "stuffed" -> "Stuffed_Crust.jpg";
            case "deep" -> "deep_dish.jpg";
            default -> "userIcon_yellow.png";
        };
    }
}

