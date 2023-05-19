package com.solvd.delivery.enums;

public enum DeliveryMode {

    //Constants with values
    AIR("Air"), SHIP("Ship"), ROAD("Road");

    private String mode;
    //Constructor to initialize the instance variable
    DeliveryMode(String mode) {
        this.mode = mode;
    }
    public String getMode() {
        return this.mode;
    }
}
