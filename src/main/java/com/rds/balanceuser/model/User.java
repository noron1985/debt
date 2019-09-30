package com.rds.balanceuser.model;

import java.util.List;

public class User {

    private int id;
    private String name;
    private String mail;
    private String password;
    private List<Balance> balances;

    public User(int id, String name, String mail, String password, List<Balance> balances) {
        this.id = id;
        this.name = name;
        this.mail = mail;
        this.password = password;
        this.balances = balances;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Balance> getBalances() {
        return balances;
    }

    public void setBalances(List<Balance> balances) {
        this.balances = balances;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                ", balances=" + balances +
                '}';
    }
}
