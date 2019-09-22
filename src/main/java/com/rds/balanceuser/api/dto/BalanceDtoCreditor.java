package com.rds.balanceuser.api.dto;

// à qui je dois de l'argent
public class BalanceDtoCreditor {

    private int idTo;
    private double amount;

    protected BalanceDtoCreditor() {

    }

    public BalanceDtoCreditor(int idTo, double amount) {
        this.idTo = idTo;
        this.amount = amount;
    }

    public int getIdTo() {
        return idTo;
    }

    public double getAmount() {
        return amount;
    }
}
