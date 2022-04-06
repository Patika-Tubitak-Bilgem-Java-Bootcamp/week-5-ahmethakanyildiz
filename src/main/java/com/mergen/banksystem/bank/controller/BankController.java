package com.mergen.banksystem.bank.controller;

import com.mergen.banksystem.bank.dto.IncreaseBalanceDTO;
import com.mergen.banksystem.bank.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/bank")
@RestController
public class BankController {

    private final BankService bankService;

    @Autowired
    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @PostMapping("/changebalance")
    public ResponseEntity<String> changeBalance(@RequestBody IncreaseBalanceDTO increaseBalanceDTO){
        int result = bankService.changeBalance(increaseBalanceDTO);
        if(result==0) return ResponseEntity.status(HttpStatus.OK).body("OK");
        else if(result == 1) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Wrong password!");
        else if(result == 2) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("There is no account with this tckno!");
        else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ERROR");
    }
}
