package com.solvd.delivery;

import com.solvd.delivery.exception.DeliveryPartnerException;

public class DeliveryPartner {
    public static String Partner;
    private String name;

    public DeliveryPartner(String name) {

        this.setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static DeliveryPartner choosePartner(double basePrice) {

        String partnerName = null;
        try {
            if (basePrice < 0) {
                throw new DeliveryPartnerException("Invalid basePrice: " + basePrice);
            } else if (basePrice < 10) {
                partnerName = "Partner A";
            } else if (basePrice < 20) {
                partnerName = "Partner B";
            } else {
                partnerName = "Partner C";
            }
        } catch (DeliveryPartnerException e) {

            System.err.println("An exception occurred in choosing partner " + e.getMessage());
            return new DeliveryPartner(partnerName);
        }
        return new DeliveryPartner(partnerName);
    }

}
