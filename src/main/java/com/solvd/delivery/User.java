package com.solvd.delivery;

import java.util.ArrayList;

public class User {
    private int id;
    private String userName;
    private String email;
    private ArrayList<User> usersList;

    public User(int id, String userName, String email) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.usersList = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public ArrayList<User> getUsersList() {
        return usersList;
    }

    public void setUsersList(ArrayList<User> usersList) {
        this.usersList = usersList;
    }
}
