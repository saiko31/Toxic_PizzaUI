package com.example.toxic_pizzaui.DataHandling;
import java.lang.reflect.Array;
import java.util.*;

//Class that will store user data such as password, username, phone#, deliveryAddress, etc.
public class userLoginData {
    private String userPassword;
    private String userName;
    private String userAddress;
    private ArrayList<String> userStorage = new ArrayList<String>();

    //Empty Constructor since there are getters and setters for the specific variable types
    public userLoginData(String userPassword, String userName, String userAddress){

    }
    //Setters for the user's password, userName, and userAddress
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserAddress(String userAddress){
        this.userAddress = userAddress;
    }

    //Getters for the user's password, userName, and userAddress
    public String getUserPassword() {
        return userPassword;
    }

    public String getUserName(){
        return userName;
    }

    public String getUserAddress(){
        return userAddress;
    }

}
