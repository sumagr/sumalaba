package com.solvd.delivery.interfaces;

public interface CreditCardInterface {

    public default void getCVV(){

    }

    public default String getCardNumber(){
        return null;
    }
}
