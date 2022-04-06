package com.mergen.banksystem.bank.service;

import com.mergen.banksystem.bank.dto.IncreaseBalanceDTO;
import com.mergen.banksystem.bank.repository.BankRepository;
import com.mergen.banksystem.person.entity.Person;
import com.mergen.banksystem.person.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankServiceImpl implements  BankService{

    private final BankRepository bankRepository;
    private final PersonRepository personRepository;

    @Autowired
    public BankServiceImpl(BankRepository bankRepository, PersonRepository personRepository) {
        this.bankRepository = bankRepository;
        this.personRepository = personRepository;
    }

    @Override
    public int changeBalance(IncreaseBalanceDTO increaseBalanceDTO){
        if(!bankRepository.getBank().getPassword().equals(increaseBalanceDTO.getBankPassword())){
            return 1;
        }
        Person person = personRepository.getPersonByTckno(increaseBalanceDTO.getTckno());
        if(person==null){
            return 2;
        }
        int balance = person.getBalance() + increaseBalanceDTO.getAmount();
        person.setBalance(balance);
        boolean result=personRepository.updatePerson(person);
        if(result) return 0;
        else return 3;

    }
}
