package com.flipkart.bean;

public class User {
    private int userID;
    private String name;
    private String password;
    private String address;

    public User(int userID, String name, String password, String address) {
        this.userID = userID;
        this.name = name;
        this.password = password;
        this.address = address;
    }

    public User() {
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword() {
        return password;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
