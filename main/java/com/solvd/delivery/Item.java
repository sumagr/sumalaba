package com.solvd.delivery;

public class Item {
    private String type;
    public String description;
    private double price;
    private double weight;

    public Item(String type, String description, double price, double weight) {

        this.type = type;
        this.description = description;
        this.price = price;
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight(){return weight;}

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
