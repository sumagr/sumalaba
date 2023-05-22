package com.solvd.delivery.enums;

public enum DeliveryPartner {

    PARTNER_A("Partner A"), PARTNER_B("Partner B"), PARTNER_C("Partner B");

    private String partnerName;
    //Constructor to initialize the instance variable
    DeliveryPartner(String partnerName) {
        this.partnerName = partnerName;
    }
    public String getPartnerName() {
        return this.partnerName;
    }
}
