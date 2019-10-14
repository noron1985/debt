package com.rds.balanceuser.dao.impl;

import com.rds.balanceuser.dao.UserDao;
import com.rds.balanceuser.model.Balance;
import com.rds.balanceuser.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@Primary
public class UserDaoPostgresImpl implements UserDao, RowMapper<User> {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private BalanceDaoPostgresImpl bdp;


    @Override
    public User findById(int id) {
        try {
            return jdbcTemplate.queryForObject(
                    "SELECT * FROM public.user WHERE id = ?", new Object[]{id}, this::mapRow);
        } catch (EmptyResultDataAccessException e) {
            System.out.println("Empty result" + e);
            return null;
        }
    }

    @Override
    public User findByName(String name) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query("SELECT * FROM public.user", this::mapRow);
    }

    @Override
    public User save(User user) {
        return null;
    }

    public List<Balance> allBalances() {
        return bdp.findAll();
    }

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        return new User(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getString("mail"),
                resultSet.getString("password"),
                allBalances());
    }
}
