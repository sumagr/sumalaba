package com.solvd.delivery.enums;

public enum Distance {

    DISTANCE(10000);

    private double distance;
    //Constructor to initialize the instance variable
    Distance(double distance) {
        this.distance = distance;
    }
    public double getDistance() {
        return this.distance;
    }
}
