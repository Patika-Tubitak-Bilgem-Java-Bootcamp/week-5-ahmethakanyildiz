package com.mergen.banksystem.person.entity;

import java.util.UUID;

public class Person {

    private UUID id;
    private String tckno;
    private String password;
    private Integer birthYear;
    private Integer balance;
    private Integer debt;

    public Person(String tckno, String password, Integer birthYear) {
        this.id = UUID.randomUUID();
        this.tckno = tckno;
        this.password = password;
        this.birthYear=birthYear;
        this.balance = 0;
        this.debt=0;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTckno() {
        return tckno;
    }

    public void setTckno(String tckno) {
        this.tckno = tckno;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Integer getDebt() {
        return debt;
    }

    public void setDebt(Integer debt) {
        this.debt = debt;
    }
}
