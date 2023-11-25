package com.example.toxic_pizzaui.objects;

import java.sql.Connection;


public class CrustType {



    private String description;
    private float price;


    public void CrustType(String crustType){


        if(crustType.equalsIgnoreCase("thin crust")){
            this.price = 0.99f;
        }
        else if(crustType.equalsIgnoreCase("stuffed crust")){
            this.price = 1.49f;
        }
        else if(crustType.equalsIgnoreCase("deep dish")){
            this.price = 1.99f;
        }
    }

    public String getDescription() {
        return description;
    }

    public float getPrice() {
        return price;
    }
}
