package com.solvd.delivery;

import com.solvd.delivery.enums.DeliveryMode;
import com.solvd.delivery.enums.Distance;
import com.solvd.delivery.enums.Speed;
import com.solvd.delivery.enums.Weight;
import com.solvd.delivery.exception.DeliveryCalculatorException;

import java.util.List;

public class DeliveryCalculator {
    Address origin;
    Address destination;

    Item item;
    private String partner;
    private DeliveryMode mode;
    private Distance distance;
    private Speed speed;

    private List<Item> Packages;
    private Weight weight;


    public DeliveryCalculator(Address origin, Address destination) {
        this.origin = origin;
        this.destination = destination;
    }

    public double calculateDeliveryCharge() throws DeliveryCalculatorException {
        //Collection Stream
        double weight = getPackages().stream()
                .mapToDouble(Item::getWeight)
                .sum();

        double weightCharge = getWeightCharge(weight);
        double distanceCharge = getDistanceCharge(distance, mode);
        double speedCharge = getSpeedCharge(getSpeed());
        double partnerCharge = getPartnerCharge(this.partner);

        try {
            double totalCharge = weightCharge + distanceCharge + speedCharge + partnerCharge;
            // Assume 1 euro = 0.85 dollars
            double exchangeRate = 0.85;
            return totalCharge * exchangeRate;
        } catch (Exception e) {
            System.err.println("An exception occurred while calculating the delivery charge: " + e.getMessage());
            return -1; // Return a default value or error code to indicate failure
        }
    }

    private double getWeightCharge(double weight) {
        double weightCharge;

        if (weight <= 5) {
            weightCharge = 10.0;  // Flat charge for weights up to 5 kg
        } else if (weight <= 10) {
            weightCharge = 15.0;  // Flat charge for weights between 5 kg and 10 kg
        } else {
            // Calculate charge per kilogram for weights above 10 kg
            double excessWeight = weight - 10;
            double chargePerKg = 2.0;  // Charge per kilogram for weights above 10 kg
            weightCharge = 15.0 + (excessWeight * chargePerKg);
        }

        return weightCharge;
    }

    public double getDistanceCharge (Distance distance, DeliveryMode mode) throws DeliveryCalculatorException {
        if (mode.getMode().equalsIgnoreCase("air")) {
            return distance.getDistance() * 0.5;
        } else if (mode.getMode().equalsIgnoreCase("land")) {
            return distance.getDistance() * 0.25;
        } else {
            throw new DeliveryCalculatorException("Invalid mode: " + mode);
        }
    }

    public double getSpeedCharge(Speed speed) throws DeliveryCalculatorException {
        if (speed.getSpeed().equalsIgnoreCase("express")) {
            return 10.0;
        } else if (speed.getSpeed().equalsIgnoreCase("standard")) {
            return 5.0;
        } else {
            throw new DeliveryCalculatorException ("Invalid speed: " + speed);
        }
    }

    public double getPartnerCharge(String partner) throws DeliveryCalculatorException {
        if (partner.equalsIgnoreCase("Partner A")) {
            return 20.0;
        } else if (partner.equalsIgnoreCase("Partner B")) {
            return 15.0;
        } else if (partner.equalsIgnoreCase("Partner C")) {
            return 10.0;
        } else {
            throw new DeliveryCalculatorException("Invalid partner: " + partner);
        }
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

    public Weight getWeight() {
        return getWeight();
    }

    public void setWeight(Weight weight) {
        this.weight = weight;
    }

    public String getPartner() {
        return partner;
    }

    public DeliveryMode getMode() {
        return mode;
    }

    public void setMode(DeliveryMode mode) {
        this.mode = mode;
    }

    public Distance getDistance() {
        return distance;
    }

    public void setDistance(Distance distance) {
        this.distance = distance;
    }

    public Speed getSpeed() {
        return speed;
    }

    public void setSpeed(Speed speed) {
        this.speed = speed;
    }

    public List<Item> getPackages() {
        return Packages;
    }

    public void setPackages(List<Item> packages) {
        Packages = packages;
    }

    public void setPartner(String deliveryPartner) {
        this.partner = deliveryPartner;
    }
}