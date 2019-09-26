package com.rds.balanceuser.service;

import com.rds.balanceuser.api.dto.BalanceDto;
import com.rds.balanceuser.api.dto.BalanceDtoCreditor;
import com.rds.balanceuser.api.dto.BalanceDtoDebitor;
import com.rds.balanceuser.dao.BalanceDao;
import com.rds.balanceuser.model.Balance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class BalanceService implements Function<Balance, BalanceDto> {

    private final Function<Balance, BalanceDtoDebitor> DtoDebitorConverter = this::DtoDebitorConverter;
    private final Function<Balance, BalanceDtoCreditor> DtoCreditorConverter = this::DtoCreditorConverter;

    @Autowired
    public BalanceDao balanceDao;

    public BalanceDtoCreditor DtoCreditorConverter(Balance balance) {
        return new BalanceDtoCreditor(balance.getIdto(), balance.getAmount());
    }

    public BalanceDtoDebitor DtoDebitorConverter(Balance balance) {
        return new BalanceDtoDebitor(balance.getIdfrom(), balance.getAmount());
    }

    public List<BalanceDtoCreditor> findAllCreditor(int id) {
        return balanceDao.findCreditor(id).stream().map(DtoCreditorConverter).collect(Collectors.toList());
    }

    public List<BalanceDtoCreditor> findAllCreditor() {
        return balanceDao.findAllCreditor().stream().map(DtoCreditorConverter).collect(Collectors.toList());
    }

    public List<BalanceDtoDebitor> findAllDebitor() {
        return balanceDao.findDebitor(false).stream().map(DtoDebitorConverter).collect(Collectors.toList());
    }

    public List<BalanceDto> findAllBalance() {
        return balanceDao.findAll().stream().map(this::apply).collect(Collectors.toList());
    }

    public Balance addBalance(Balance balance) {
        return balanceDao.add(balance);
    }

    public Balance addBalanceToUser(Balance balance, String name) {
        return balanceDao.add(balance, name);
    }

    @Override
    public BalanceDto apply(Balance balance) {
        return new BalanceDto(balance.getIdfrom(), balance.getIdto(), balance.getAmount());
    }
}
