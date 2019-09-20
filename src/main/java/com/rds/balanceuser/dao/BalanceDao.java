package com.rds.balanceuser.dao;

import com.rds.balanceuser.model.Balance;

import java.util.List;

public interface BalanceDao {

    List<Balance> findAll();

    List<Balance> findCreditor(int idTo);

    List<Balance> findDebtor(int idFrom);

}
