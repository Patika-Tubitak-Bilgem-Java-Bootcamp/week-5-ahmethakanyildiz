package com.mergen.banksystem.bank.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IncreaseBalanceDTO {
    private String tckno;
    private String bankPassword;
    private Integer amount;

    public IncreaseBalanceDTO(@JsonProperty("tckno") String tckno,
                              @JsonProperty("bankPassword") String bankPassword,
                              @JsonProperty("amount") Integer amount) {
        this.tckno = tckno;
        this.bankPassword = bankPassword;
        this.amount = amount;
    }

    public String getTckno() {
        return tckno;
    }

    public void setTckno(String tckno) {
        this.tckno = tckno;
    }

    public String getBankPassword() {
        return bankPassword;
    }

    public void setBankPassword(String bankPassword) {
        this.bankPassword = bankPassword;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
