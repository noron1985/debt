package com.rds.balanceuser.api.dto;

public class BalanceDto {

    private int Idfrom;
    private int Idto;
    private double amount;

    public BalanceDto(int idfrom, int idto, double amount) {
        Idfrom = idfrom;
        Idto = idto;
        this.amount = amount;
    }

    public int getIdfrom() {
        return Idfrom;
    }

    public int getIdto() {
        return Idto;
    }

    public double getAmount() {
        return amount;
    }


}
