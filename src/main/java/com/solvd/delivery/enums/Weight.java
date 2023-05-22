package com.solvd.delivery.enums;

public enum Weight {

    WEIGHT(100);

    private double weight;
    //Constructor to initialize the instance variable
    Weight(double weight) {
        this.weight = weight;
    }
    public double getWeight() {
        return this.weight;
    }
}
