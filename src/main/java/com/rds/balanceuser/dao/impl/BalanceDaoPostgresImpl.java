package com.rds.balanceuser.dao.impl;

import com.rds.balanceuser.dao.BalanceDao;
import com.rds.balanceuser.model.Balance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@Primary
public class BalanceDaoPostgresImpl implements BalanceDao, RowMapper<Balance> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Balance> findAll() {
        return jdbcTemplate.query("SELECT * FROM public.balance", this);
    }

    @Override
    public List<Balance> findCreditors() {
        return jdbcTemplate.query(
                "SELECT * FROM public.balance WHERE isCreditor = true",
                this::mapRow);
    }

    @Override
    public List<Balance> findDebitors() {
        return jdbcTemplate.query(
                "SELECT * FROM public.balance WHERE isCreditor = false",
                this::mapRow);
    }

    @Override
    public Balance add(Balance balance, String name) {
        return null;
    }

    @Override
    public Balance add(Balance balance) {
        return null;
    }

    //TO DELETE after full integration of DB
    @Override
    public List<Balance> findCreditor(int idTo) {
        return null;
    }

    @Override
    public List<Balance> findAllCreditor() {
        return null;
    }

    @Override
    public List<Balance> findDebitor(boolean isCreditor) {
        return null;
    }

    @Override
    public Balance mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Balance(resultSet.getInt("idfrom"),
                resultSet.getInt("idto"),
                resultSet.getDouble("amount"),
                resultSet.getBoolean("iscreditor"));
    }
}
