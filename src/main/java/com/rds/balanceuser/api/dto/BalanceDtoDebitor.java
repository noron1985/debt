package com.rds.balanceuser.api.dto;

// ceux qui me doivent de l'argent
public class BalanceDtoDebitor {

    private int idFrom;
    private double amount;

    protected BalanceDtoDebitor() {
    }

    public BalanceDtoDebitor(int idFrom, double amount) {
        this.idFrom = idFrom;
        this.amount = amount;
    }

    public int getFrom() {
        return idFrom;
    }

    public double getAmount() {
        return amount;
    }

}
