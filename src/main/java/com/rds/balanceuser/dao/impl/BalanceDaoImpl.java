package com.rds.balanceuser.dao.impl;

import com.rds.balanceuser.api.dto.UserDto;
import com.rds.balanceuser.dao.BalanceDao;
import com.rds.balanceuser.model.Balance;
import com.rds.balanceuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

//celui qui doit de l'argent dans le présent c'est le FROM
//celui qui attend l'argent c'est le TO

@Repository
public class BalanceDaoImpl implements BalanceDao {

    private List<Balance> balances = new ArrayList<>();

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-DD");

    @Autowired
    private UserService userService;

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
    public List<Balance> findAllCreditor() {
        return balances.stream()
                .filter(Balance::isCreditor)
                .collect(toList());
    }

    @Override
    public List<Balance> findAll() {
        return balances;
    }

    @Override
    public Balance add(Balance balance, String name) {
        Balance temp = new Balance(
                balance.getIdfrom(),
                balance.getIdto(),
                balance.getAmount(),
                balance.isCreditor()
        );

        if (balance.isCreditor()) {
            // user became creditor
            UserDto userToCredit = userService.findById(balance.getIdfrom());
            List<Balance> cr = userToCredit.getBalances();
            cr.add(balance);
            // user became debitor
            UserDto userToCharge = userService.findById(balance.getIdto());
            List<Balance> ch = userToCharge.getBalances();
            temp.setCreditor(false);
            ch.add(temp);
//            Balance b1 = r.stream().filter(balanceToChange -> balanceToChange.getAmount()==temp.getAmount()).findAny().get();
//            userToRemoveBalance.setBalances(r);
        }
        //TODO opposite way if Iscreditor is false
        else {
            // user became creditor
            UserDto userToCharge = userService.findById(balance.getIdfrom());
            List<Balance> ch = userToCharge.getBalances();
            ch.add(balance);
            // user to charge
            UserDto userToCredit = userService.findById(balance.getIdto());
            List<Balance> cr = userToCredit.getBalances();
            temp.setCreditor(true);
            cr.add(temp);
        }
        //No needed
        //UserDto userToAddBalance = userService.findByName(name);
        return balance;
    }

    @Override
    public Balance add(Balance balance, int id) {
        return null;
    }

    @Override
    public Balance add(Balance balance) {
        balances.add(balance);
        return balance;
    }

    @Override
    public List<Balance> findCreditors() {
        return null;
    }

    @Override
    public List<Balance> findDebitors() {
        return null;
    }

//    @PostConstruct
//    public void onPostConstruct() {
//        balances.add(new Balance(1, 2, 50, true));
//        balances.add(new Balance(1, 2, 1.99, false));
//        balances.add(new Balance(1, 3, 120, true));
//        balances.add(new Balance(1, 4, 10, true));
//    }
}
