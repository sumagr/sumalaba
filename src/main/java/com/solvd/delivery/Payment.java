package com.solvd.delivery;

import com.solvd.delivery.interfaces.PaymentProcessing;

public abstract class Payment implements PaymentProcessing {
    private double amount;
    private String paymentMethod;

    public Payment(double amount) {
        this.setAmount(amount);
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public abstract void processPayment();

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
