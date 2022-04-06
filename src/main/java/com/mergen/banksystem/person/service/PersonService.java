package com.mergen.banksystem.person.service;

import com.mergen.banksystem.bank.dto.CreditDTO;
import com.mergen.banksystem.person.dto.CreatePersonDTO;
import com.mergen.banksystem.person.dto.SendMoneyDTO;
import com.mergen.banksystem.person.dto.ShowInfoDTO;

public interface PersonService {

    int createPerson(CreatePersonDTO createPersonDTO);
    String showInfo(ShowInfoDTO showInfoDTO);
    int sendMoney(SendMoneyDTO sendMoneyDTO);
    int payTakeCredit(CreditDTO creditDTO);
}
