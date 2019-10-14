package com.rds.balanceuser.service;

import com.rds.balanceuser.api.dto.BalanceDto;
import com.rds.balanceuser.api.dto.BalanceDtoCreditor;
import com.rds.balanceuser.api.dto.BalanceDtoDebtor;
import com.rds.balanceuser.dao.BalanceDao;
import com.rds.balanceuser.model.Balance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;

@Service
public class BalanceService implements Function<Balance, BalanceDto> {

    private final Function<Balance, BalanceDtoDebtor> DtoDebitorConverter = this::DtoDebitorConverter;
    private final Function<Balance, BalanceDtoCreditor> DtoCreditorConverter = this::DtoCreditorConverter;

    @Autowired
    public BalanceDao balanceDao;

    public List<BalanceDto> findAllBalance() {
        return balanceDao.findAll().stream().map(this::apply).collect(toList());
    }

    public List<BalanceDto> findCreditors() {
        return balanceDao.findCreditors().stream().map(this::apply).collect(toList());
    }

    public List<BalanceDto> findDebtors() {
        return balanceDao.findDebitors().stream().map(this::apply).collect(toList());
    }

    public Balance addBalance(Balance balance) {
        return balanceDao.add(balance);
    }

    public Balance addBalanceToUser(Balance balance, String name) {
        return balanceDao.add(balance, name);
    }

    public Balance addBalanceToUserById(Balance balance, int id) {
        return balanceDao.add(balance, id);
    }

    // TO DELETE after DB fully integrated
    public List<BalanceDtoCreditor> findAllCreditor(int id) {
        return balanceDao.findCreditor(id).stream().map(DtoCreditorConverter).collect(toList());
    }

    public List<BalanceDtoCreditor> findAllCreditor() {
        return balanceDao.findAllCreditor().stream().map(DtoCreditorConverter).collect(toList());
    }

    public List<BalanceDtoDebtor> findAllDebitor() {
        return balanceDao.findDebitor(false).stream().map(DtoDebitorConverter).collect(toList());
    }

    public BalanceDtoCreditor DtoCreditorConverter(Balance balance) {
        return new BalanceDtoCreditor(balance.getIdto(), balance.getAmount());
    }

    public BalanceDtoDebtor DtoDebitorConverter(Balance balance) {
        return new BalanceDtoDebtor(balance.getIdfrom(), balance.getAmount());
    }

    @Override
    public BalanceDto apply(Balance balance) {
        return new BalanceDto(
                balance.getIdfrom(),
                balance.getIdto(),
                balance.getAmount());
        //balance.isCreditor());
    }
}
