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
    public List<Balance> findDebitor(boolean isCreditor) {
        return balances.stream()
                .filter(balance -> !balance.isCreditor())
                .collect(toList());
    }

    //je cherche tout ceux à qui je dois de l'argent
    @Override
    public List<Balance> findCreditor(int idTo) {
        return balances.stream()
                .filter(balance -> balance.getIdto() == idTo && balance.isCreditor())
                .collect(toList());
    }

    @Override
    public List<Balance> findAll() {
        return balances;
    }

    @Override
    public Balance save(Balance balance) {
        balances.add(balance);
        return balance;
    }

    @PostConstruct
    public void onPostConstruct() {
        balances.add(new Balance(1, 2, 50, true));
        balances.add(new Balance(1, 3, 120, true));
        balances.add(new Balance(1, 4, 10, true));
    }

}
