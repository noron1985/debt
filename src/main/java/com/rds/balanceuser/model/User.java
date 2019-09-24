package com.rds.balanceuser.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name")// pour changer le nom par défaut de la variable
    private String name;
    @Basic(optional = false, fetch = FetchType.EAGER) // contrainte pour null
    // FetchType Lazy pour un gros volume de donnée
    @Column(unique = true)
    // peut produire un erreur qu'on peut catcher et envoyer un message à la personne disant que l'email doit etre unique
    private String mail;
    @Transient // pas de persistence dans la DB
    private String password;
    private List<Balance> balances;


    protected User() {
    }


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


}
