package com.solvd.delivery.interfaces;

public interface AddressInterface {

    public default String  getCity(){
        return null;
    }

    public default String getState(){
        return null;
    }
}
