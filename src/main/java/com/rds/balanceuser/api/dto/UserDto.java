package com.rds.balanceuser.api.dto;

import com.rds.balanceuser.model.Balance;

import java.util.List;

public class UserDto {

    private String name;
    private List<Balance> balances;

    protected UserDto(){
    }

    public UserDto(String name, List<Balance> balances) {
        this.name = name;
        this.balances = balances;
    }

    public String getName() {
        return name;
    }

    public List<Balance> getBalances() {
        return balances;
    }
}
