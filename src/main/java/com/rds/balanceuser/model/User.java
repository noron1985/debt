package com.rds.balanceuser.model;

import java.util.List;

public class User {

    private int id;
    private String name;
    private String mail;
    private String password;
    private List<Debt> debts;

    public User(int id, String name, String mail, String password, List<Debt> debts) {
        this.id = id;
        this.name = name;
        this.mail = mail;
        this.password = password;
        this.debts = debts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<Debt> getDebts() {
        return debts;
    }

    public void setDebts(List<Debt> debts) {
        this.debts = debts;
    }


}
