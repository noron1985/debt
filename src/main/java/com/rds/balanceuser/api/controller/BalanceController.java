package com.rds.balanceuser.api.controller;

import com.rds.balanceuser.api.dto.BalanceDtoCreditor;
import com.rds.balanceuser.api.dto.BalanceDtoDebitor;
import com.rds.balanceuser.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BalanceController {

    @Autowired
    private BalanceService balanceService;

    @GetMapping("/api/balance/creditor")
    public List<BalanceDtoCreditor> allCreditor() {
        return balanceService.findAllCreditor();
    }

    @GetMapping("/api/balance/debitor")
    public List<BalanceDtoDebitor> allDebitor() {
        return balanceService.findAllDebitor();
    }

}
