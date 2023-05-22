package com.solvd.delivery;

import com.solvd.delivery.interfaces.CreditCardInterface;

public class CreditCard extends Payment implements CreditCardInterface {
    private String cardNumber;

    private String expirationDate;

    protected int cvv;

    protected double balance;

    public CreditCard(double amount, String cardNumber, String expirationDate, int cvv, double balance) {

        super(amount);
        this.setCardNumber(cardNumber);
        this.setExpirationDate(expirationDate);
        this.setCvv(cvv);
        this.setBalance(balance);
    }

    public void processPayment() {
        // Check if the balance on the credit card is sufficient to cover the payment
        if (getAmount() <= balance) {
            // Payment successful, deduct the amount from the balance
            balance -= getAmount();
            System.out.println("Payment of " + getAmount() + " processed successfully with credit card ending in "
                    + cardNumber.substring(cardNumber.length() - 4));
        } else {
            // Payment failed, not enough balance on the card
            System.out.println("Payment failed: not enough balance on credit card ending in "
                    + cardNumber.substring(cardNumber.length() - 4));
        }
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
