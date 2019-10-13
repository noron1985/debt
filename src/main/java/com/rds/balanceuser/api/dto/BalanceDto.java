package com.rds.balanceuser.api.dto;

public class BalanceDto {

    private int Idfrom;
    private int Idto;
    private double amount;
    private boolean isCreditor;
    //private Date input;

    public BalanceDto(int idfrom, int idto, double amount, boolean isCreditor) {
        this.Idfrom = idfrom;
        this.Idto = idto;
        this.amount = amount;
        this.isCreditor = isCreditor;

        //this.input = new Date();
    }

    public BalanceDto(int idfrom, int idto, double amount) {
        this.Idfrom = idfrom;
        this.Idto = idto;
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

    //public boolean isCreditor() { return isCreditor; }


}
