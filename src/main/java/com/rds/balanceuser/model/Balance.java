package com.rds.balanceuser.model;

public class Balance {

    private int Idfrom;
    private int Idto;
    private double amount;
    private boolean isCreditor;

    public Balance(int idfrom, int idto, double amount, boolean isCreditor) {
        Idfrom = idfrom;
        Idto = idto;
        this.amount = amount;
        this.isCreditor = isCreditor;
    }

    public int getIdfrom() {
        return Idfrom;
    }

    public void setIdfrom(int idfrom) {
        Idfrom = idfrom;
    }

    public int getIdto() {
        return Idto;
    }

    public void setIdto(int idto) {
        Idto = idto;
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
    public int hashCode() {
        return 0;
    }
}
