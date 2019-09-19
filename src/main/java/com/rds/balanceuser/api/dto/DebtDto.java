package com.rds.balanceuser.api.dto;

public class DebtDto {

    private int from;
    private int to;
    private double amount;

    protected DebtDto(){

    }

    public DebtDto(int from, int to, double amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public double getAmount() {
        return amount;
    }
}
