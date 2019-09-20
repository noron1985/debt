package com.rds.balanceuser.dao.impl;

import com.rds.balanceuser.dao.BalanceDao;
import com.rds.balanceuser.model.Balance;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

//celui qui doit de l'argent dans le présent c'est le FROM
//celui qui attend l'argent c'est le TO

@Repository
public class BalanceDaoImpl implements BalanceDao {

    private List<Balance> balances = new ArrayList<>();

    //je cherche tout ceux qui me doivent de l'argent
    @Override
    public List<Balance> findDebtor(int idFrom) {
        return balances.stream()
                .filter(balance -> balance.getIdfrom() == idFrom)
                .collect(toList());
    }

    //je cherche tout ceux à qui je dois de l'argent

    @Override
    public List<Balance> findCreditor(int idTo) {
        return balances.stream()
                .filter(balance -> balance.getIdto() == idTo)
                .collect(toList());
    }

    @Override
    public List<Balance> findAll() {
        return balances;
    }

}
