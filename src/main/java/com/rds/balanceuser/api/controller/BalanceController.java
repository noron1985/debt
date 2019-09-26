package com.rds.balanceuser.api.controller;

import com.rds.balanceuser.api.dto.BalanceDto;
import com.rds.balanceuser.api.dto.BalanceDtoCreditor;
import com.rds.balanceuser.api.dto.BalanceDtoDebitor;
import com.rds.balanceuser.model.Balance;
import com.rds.balanceuser.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BalanceController {

    @Autowired
    private BalanceService balanceService;

    // to delete
    @GetMapping("/api/balance/creditor/{id}")
    public List<BalanceDtoCreditor> allCreditor(@PathVariable int id) {
        return balanceService.findAllCreditor(id);
    }

    @GetMapping("api/balance/allcreditor")
    public List<BalanceDtoCreditor> allCreditor() {
        return balanceService.findAllCreditor();
    }

    @GetMapping("/api/balance/debitor")
    public List<BalanceDtoDebitor> allDebitor() {
        return balanceService.findAllDebitor();
    }

    @GetMapping("api/balance")
    public List<BalanceDto> allBalance() {
        return balanceService.findAllBalance();
    }

    @PostMapping("api/balance/{name}")
    public Balance addBalanceToUser(@RequestBody Balance balance, @PathVariable String name) {
        return balanceService.addBalanceToUser(balance, name);
    }

}
