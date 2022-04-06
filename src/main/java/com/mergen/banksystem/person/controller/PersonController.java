package com.mergen.banksystem.person.controller;

import com.mergen.banksystem.bank.dto.CreditDTO;
import com.mergen.banksystem.person.dto.CreatePersonDTO;
import com.mergen.banksystem.person.dto.SendMoneyDTO;
import com.mergen.banksystem.person.dto.ShowInfoDTO;
import com.mergen.banksystem.person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/addperson")
    public ResponseEntity<String> addPerson(@RequestBody CreatePersonDTO createPersonDTO){
        int result =personService.createPerson(createPersonDTO);
        if(result==0) return ResponseEntity.status(HttpStatus.OK).body("Personal account is created!");
        else if(result==1) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("This tckno already in use!");
        else if(result==2) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Password cannot contain birth year!");
        else if(result==3) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid birth year!");
        else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ERROR!");
    }

    @PostMapping("/showinfo")
    public ResponseEntity<String> showAccountInfo(@RequestBody ShowInfoDTO showInfoDTO){
        String result = personService.showInfo(showInfoDTO);
        if(result.startsWith("Account Information")) return ResponseEntity.status(HttpStatus.OK).body(result);
        else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }

    @PostMapping("/sendmoney")
    public ResponseEntity<String> sendMoney(@RequestBody SendMoneyDTO sendMoneyDTO){
        int result = personService.sendMoney(sendMoneyDTO);
        if(result==0) return ResponseEntity.status(HttpStatus.OK).body("OK");
        else if(result==1) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid sender tckno!");
        else if(result==2) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Wrong Password!");
        else if(result==3) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid receiver tckno!");
        else if(result==4) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid amount!");
        else if(result==5) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Insufficient balance!");
        else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ERROR!");
    }

    @PostMapping("/paytakecredit")
    public ResponseEntity<String>  payTakeCredit(@RequestBody CreditDTO creditDTO){
        int result = personService.payTakeCredit(creditDTO);
        if(result==0) return ResponseEntity.status(HttpStatus.OK).body("OK");
        else if(result==1) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("There is no user with this tckno!");
        else if(result==2) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Wrong Password!");
        else if(result==3) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid amount!");
        else if(result==4) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Insufficient balance!");
        else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ERROR!");
    }
}
