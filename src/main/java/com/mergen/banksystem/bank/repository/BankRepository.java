package com.mergen.banksystem.bank.repository;

import com.mergen.banksystem.bank.entity.Bank;
import org.springframework.stereotype.Repository;

@Repository
public class BankRepository {

    private static Bank bank = new Bank("Ziraat Bankası", "123");

    public Bank getBank(){
        return bank;
    }
}
