package com.rds.balanceuser.api.dto;

import java.util.Date;

public class BalanceDto {

    private int Idfrom;
    private int Idto;
    private double amount;
    private Date input;

    public BalanceDto(int idfrom, int idto, double amount) {
        this.Idfrom = idfrom;
        this.Idto = idto;
        this.amount = amount;
        //this.input = new Date();
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

    public Date getInput() {
        return input;
    }


}
