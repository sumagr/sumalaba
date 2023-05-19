package com.solvd.delivery.interfaces;

public interface DebitCardInterface {

    public default void getCVV(){

    }

    public default String getCardNumber(){
        return null;
    }
}
