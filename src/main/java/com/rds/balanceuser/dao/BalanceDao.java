package com.rds.balanceuser.dao;

import com.rds.balanceuser.model.Balance;

import java.util.List;

public interface BalanceDao {

    List<Balance> findAll();

    List<Balance> findCreditor(int idTo);

    List<Balance> findAllCreditor();

    List<Balance> findDebitor(boolean isCreditor);

    Balance add(Balance balance, String name);

    Balance add(Balance balance, int id);

    Balance add(Balance balance);

    List<Balance> findCreditors();

    List<Balance> findDebitors();



}
