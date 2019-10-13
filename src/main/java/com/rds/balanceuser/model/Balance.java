package com.rds.balanceuser.model;

public class Balance {

    private int Idfrom;
    private int Idto;
    private double amount;
    private boolean isCreditor;

    public Balance(int idfrom, int idto, double amount, boolean isCreditor) {
        this.Idfrom = idfrom;
        this.Idto = idto;
        this.amount = amount;
        this.isCreditor = isCreditor;
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

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isCreditor() {
        return isCreditor;
    }

    public void setCreditor(boolean creditor) {
        isCreditor = creditor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Balance balance = (Balance) o;
        return Idfrom == balance.Idfrom &&
                Idto == balance.Idto;
    }

    @Override
    public String toString() {
        return "Balance{" +
                "Idfrom=" + Idfrom +
                ", Idto=" + Idto +
                ", amount=" + amount +
                ", isCreditor=" + isCreditor +
                '}';
    }
}
