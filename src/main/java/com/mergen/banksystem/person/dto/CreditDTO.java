package com.mergen.banksystem.bank.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreditDTO {
    private String tckno;
    private String password;
    private Integer amount;
    private Integer type;

    public CreditDTO(@JsonProperty("tckno") String tckno,
                              @JsonProperty("password") String password,
                              @JsonProperty("amount") Integer amount,
                              @JsonProperty("type") Integer type) {
        this.tckno = tckno;
        this.password = password;
        this.amount = amount;
        this.type=type;
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

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
