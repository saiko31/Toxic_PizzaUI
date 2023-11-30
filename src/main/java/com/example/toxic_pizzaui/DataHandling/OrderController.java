package com.example.toxic_pizzaui.DataHandling;

import com.example.toxic_pizzaui.objects.Order;

public class OrderController {

    private static Order newOrder;

   public static void startNewOrder(){
       newOrder = new Order();
   }

   public static Order getOrder(){
       return newOrder;
   }
   public static void resetOrder(){
       newOrder = null;
   }

}
