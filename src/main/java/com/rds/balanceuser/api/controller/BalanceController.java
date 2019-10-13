package com.rds.balanceuser.api.controller;

import com.rds.balanceuser.api.dto.BalanceDto;
import com.rds.balanceuser.model.Balance;
import com.rds.balanceuser.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BalanceController {

    @Autowired
    private BalanceService balanceService;

    @GetMapping("api/balance")
    public List<BalanceDto> allBalance() {
        return balanceService.findAllBalance();
    }

    @GetMapping("api/balance/creditors")
    public List<BalanceDto> creditors() {
        return balanceService.findCreditors();
    }

    @GetMapping("/api/balance/debtors")
    public List<BalanceDto> debtors() {
        return balanceService.findDebtors();
    }

    @PostMapping("api/balance/{name}")
    public Balance addBalanceToUser(@RequestBody Balance balance, @PathVariable String name) {
        return balanceService.addBalanceToUser(balance, name);
    }

}
