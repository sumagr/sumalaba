package com.solvd.delivery;

public class Delivery {
    private Address origin;
    private Address destination;

    public Delivery(Address origin, Address destination) {

        this.origin = origin;
        this.destination = destination;
    }

    public Address getOrigin() {
        return origin;
    }

    public void setOrigin(Address origin) {
        this.origin = origin;
    }

    public Address getDestination() {
        return destination;
    }

    public void setDestination(Address destination) {
        this.destination = destination;
    }

}
