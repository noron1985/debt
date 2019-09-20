package com.rds.balanceuser.service;

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
public class BalanceService {

    private final Function<Balance, BalanceDtoDebitor> DtoDebitorConverter = this::DtoDebitorConverter;
    private final Function<Balance, BalanceDtoCreditor> DtoCreditorConverter = this::DtoCreditorConverter;
    @Autowired
    private BalanceDao balanceDao;

    public BalanceDtoCreditor DtoCreditorConverter(Balance balance) {
        return new BalanceDtoCreditor(balance.getIdto(), balance.getAmount());
    }

    public BalanceDtoDebitor DtoDebitorConverter(Balance balance) {
        return new BalanceDtoDebitor(balance.getIdfrom(), balance.getAmount());
    }

    public List<BalanceDtoCreditor> findAllCreditor() {
        return balanceDao.findAll().stream().map(DtoCreditorConverter).collect(Collectors.toList());
    }

    public List<BalanceDtoDebitor> findAllDebitor() {
        return balanceDao.findAll().stream().map(DtoDebitorConverter).collect(Collectors.toList());
    }

}
