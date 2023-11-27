package com.example.toxic_pizzaui.DataHandling;

//Class that will store receipt data and push it into the fxml file for receipts
public class ReceiptData {

    private int receiptCnt = 1;
    private float orderTotal;

    //Empty Default Constructor for Class
    public ReceiptData(int receiptCnt, float orderTotal){

    }

    //Setter methods for private variables in class
    public void setReceiptCnt(int receiptCnt){
        this.receiptCnt = receiptCnt++;
    }

    public void setOrderTotal(float orderTotal){
        this.orderTotal = orderTotal;
    }

    //Getter methods for private variables in class
    public int getReceiptCnt(){
        return receiptCnt;
    }

    public float getOrderTotal(){
        return orderTotal;
    }
}
