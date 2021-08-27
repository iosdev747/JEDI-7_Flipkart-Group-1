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

    /**
     * Method to get the UserID
     *
     * @return userID
     */
    public int getUserID() {
        return userID;
    }

    /**
     * Method to set the UserID
     *
     * @param userID
     */
    public void setUserID(int userID) {
        this.userID = userID;
    }

    /**
     * Method to get the name of a User
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Method to set the name of a User
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method to get the password of a User
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Method to set the password of a User
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Method to get the Address of a User
     *
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Method to set the address of a User
     *
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }
}
