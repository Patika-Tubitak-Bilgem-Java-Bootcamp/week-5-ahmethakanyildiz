package com.mergen.banksystem.person.repository;

import com.mergen.banksystem.person.entity.Person;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository("userRepo")
public class PersonRepository {

    private static List<Person> DB = new ArrayList<>();

    public int insertPerson(Person person){
        for(Person p:DB){
            if(p.getTckno().equals(person.getTckno())){
                return 1;
            }
        }
        if(person.getPassword().contains(String.valueOf(person.getBirthYear()))){
            return 2;
        }

        Date now = new Date();
        LocalDate localDate = now.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        if(person.getBirthYear()<1900 || person.getBirthYear()>localDate.getYear()){
            return 3;
        }
        DB.add(person);
        return 0;
    }

    public Person getPersonByTckno(String tckno){
        for(Person p:DB){
            if(p.getTckno().equals(tckno)){
                return p;
            }
        }
        return null;
    }

    public boolean updatePerson(Person person){
        for(int i=0;i<DB.size();i++){
            if(DB.get(i).getId().compareTo(person.getId())==0){
                    DB.set(i,person);
                    return true;
            }
        }
        return false;
    }

}
