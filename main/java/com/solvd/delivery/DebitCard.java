package com.solvd.delivery;

import com.solvd.delivery.interfaces.DebitCardInterface;

public class DebitCard extends Payment implements DebitCardInterface  {

    protected String cardNumber;

    private String expirationDate;

    protected int cvv;

    private double balance;

    public DebitCard(double amount, String cardNumber, String expirationDate, int cvv, double balance) {
        super(amount);
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
        this.balance = balance;

    }

    public void processPayment() {
        // Check if the balance in the bank account is sufficient to cover the payment
        if (getAmount() <= balance) {
            // Payment successful, deduct the amount from the balance
            balance -= getAmount();
            System.out.println("Payment of " + getAmount() + " processed successfully with debit card ending in "
                    + cardNumber.substring(cardNumber.length() - 4));
        } else {
            // Payment failed, not enough balance in the account
            System.out.println("Payment failed: not enough balance in bank account linked to debit card ending in "
                    + cardNumber.substring(cardNumber.length() - 4));
        }
    }

    @Override
    public void getCVV() {
        DebitCardInterface.super.getCVV();
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

}
