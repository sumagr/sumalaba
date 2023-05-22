package com.solvd.delivery.enums;

public enum Speed {
    //Constants with values
    EXPRESS("express"), NORMAL("normal");

    private String speed;
    //Constructor to initialize the instance variable
    Speed(String speed) {
        this.speed = speed;
    }
    public String getSpeed() {
        return this.speed;
    }
}
