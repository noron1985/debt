package com.rds.balanceuser.api.controller;

import com.rds.balanceuser.api.dto.BalanceDto;
import com.rds.balanceuser.model.Balance;
import com.rds.balanceuser.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/balance")
public class BalanceController {

    @Autowired
    private BalanceService balanceService;

    @GetMapping()
    @Transactional(readOnly = true)
    public List<BalanceDto> allBalance() {
        return balanceService.findAllBalance();
    }

    @GetMapping("/creditors")
    @Transactional(readOnly = true)
    public List<BalanceDto> creditors() {
        return balanceService.findCreditors();
    }

    @GetMapping("/debtors")
    @Transactional(readOnly = true)
    public List<BalanceDto> debtors() {
        return balanceService.findDebtors();
    }

    @PostMapping("/{name}")
    public Balance addBalanceToUser(@RequestBody Balance balance, @PathVariable String name) {
        return balanceService.addBalanceToUser(balance, name);
    }

    @PostMapping("/byid/{id}")
    public Balance addBalanceToUserById(@RequestBody Balance balance, @PathVariable int id) {
        return balanceService.addBalanceToUserById(balance, id);
    }

}
