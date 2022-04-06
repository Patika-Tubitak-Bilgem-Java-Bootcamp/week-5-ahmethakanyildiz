package com.mergen.banksystem.bank.service;

import com.mergen.banksystem.bank.dto.IncreaseBalanceDTO;

public interface BankService {
    int changeBalance(IncreaseBalanceDTO increaseBalanceDTO);
}
