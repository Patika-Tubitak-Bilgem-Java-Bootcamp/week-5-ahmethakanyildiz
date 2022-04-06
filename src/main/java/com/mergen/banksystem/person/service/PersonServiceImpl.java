package com.mergen.banksystem.person.service;

import com.mergen.banksystem.bank.dto.CreditDTO;
import com.mergen.banksystem.person.dto.CreatePersonDTO;
import com.mergen.banksystem.person.dto.SendMoneyDTO;
import com.mergen.banksystem.person.dto.ShowInfoDTO;
import com.mergen.banksystem.person.entity.Person;
import com.mergen.banksystem.person.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService{

    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(@Qualifier("userRepo") PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public int createPerson(CreatePersonDTO createPersonDTO) {
        Person person = new Person(createPersonDTO.getTckno(), createPersonDTO.getPassword(), createPersonDTO.getBirthYear());
        int result = personRepository.insertPerson(person);
        return result;
    }

    @Override
    public String showInfo(ShowInfoDTO showInfoDTO){
        Person p = personRepository.getPersonByTckno(showInfoDTO.getTckno());
        if(p==null) return "There is no account with this tckno!";
        if(!p.getPassword().equals(showInfoDTO.getPassword())){
            return "Wrong password!";
        }
        String result="Account Information-----------\n";
        result=result+"TCKNO: "+p.getTckno()+"\n";
        result=result+"Birth Year: "+p.getBirthYear()+"\n";
        result=result+"Balance: "+p.getBalance()+"₺\n";
        result=result+"Debt: "+p.getDebt()+"₺\n";
        return result;
    }

    @Override
    public int sendMoney(SendMoneyDTO sendMoneyDTO){
        Person sender = personRepository.getPersonByTckno(sendMoneyDTO.getTckno());
        Person receiver = personRepository.getPersonByTckno(sendMoneyDTO.getReceiverTckno());
        if(sender==null) return 1;
        if(!sender.getPassword().equals(sendMoneyDTO.getPassword())){
            return 2;
        }
        if(receiver==null) return 3;
        if(sendMoneyDTO.getAmount()<=0) return 4;
        if(sendMoneyDTO.getAmount()>sender.getBalance()){
            return 5;
        }
        else{
            sender.setBalance(sender.getBalance()-sendMoneyDTO.getAmount());
            personRepository.updatePerson(sender);
            receiver.setBalance(receiver.getBalance()+sendMoneyDTO.getAmount());
            personRepository.updatePerson(receiver);
            return 0;
        }
    }

    @Override
    public int payTakeCredit(CreditDTO creditDTO){
        Person p = personRepository.getPersonByTckno(creditDTO.getTckno());
        if(p==null) return 1;
        if(!p.getPassword().equals(creditDTO.getPassword())){
            return 2;
        }
        if(creditDTO.getAmount()<=0) return 3;
        if(creditDTO.getType()==0){
            p.setBalance(p.getBalance()+creditDTO.getAmount());
            p.setDebt(p.getDebt()+creditDTO.getAmount());
            personRepository.updatePerson(p);
            return 0;
        }
        else{
            if(creditDTO.getAmount()>p.getBalance()){
                return 4;
            }
            else{
                if(creditDTO.getAmount()>p.getDebt()){
                    p.setBalance(p.getBalance()-p.getDebt());
                    p.setDebt(0);
                }
                else{
                    p.setBalance(p.getBalance()-creditDTO.getAmount());
                    p.setDebt(p.getDebt()-creditDTO.getAmount());
                }
                personRepository.updatePerson(p);
                return 0;
            }
        }
    }
}
