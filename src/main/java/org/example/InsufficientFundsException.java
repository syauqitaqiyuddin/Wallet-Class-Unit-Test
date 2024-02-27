package org.example;

public class InsufficientFundsException  extends Exception {

    private double attemptedAmount;
    private double currentBalance;

    public InsufficientFundsException(double attemptedAmount, double currentBalance) {
        super("Saldo tidak mencukupi");
        this.attemptedAmount = attemptedAmount;
        this.currentBalance = currentBalance;
    }

    public double getAttemptedAmount() {
        return attemptedAmount;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }
}
