package com.rds.balanceuser.api.dto;

import com.rds.balanceuser.model.Debt;

import java.util.List;

public class UserDto {

    private String name;
    private List<Debt> debts;

    protected UserDto(){
    }

    public UserDto(String name, List<Debt> debts) {
        this.name = name;
        this.debts = debts;
    }

    public String getName() {
        return name;
    }

    public List<Debt> getDebts() {
        return debts;
    }
}
