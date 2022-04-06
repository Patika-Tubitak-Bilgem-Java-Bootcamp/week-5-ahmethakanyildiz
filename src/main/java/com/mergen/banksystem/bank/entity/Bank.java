package com.mergen.banksystem.bank.entity;

public class Bank {
    private String bankName;
    private String password;

    public Bank(String bankName, String password) {
        this.bankName = bankName;
        this.password = password;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
