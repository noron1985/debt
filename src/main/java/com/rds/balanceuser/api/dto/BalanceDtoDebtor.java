package com.rds.balanceuser.api.dto;

// ceux qui me doivent de l'argent
public class BalanceDtoDebtor {

    private int idFrom;
    private double amount;

    protected BalanceDtoDebtor() {
    }

    public BalanceDtoDebtor(int idFrom, double amount) {
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
