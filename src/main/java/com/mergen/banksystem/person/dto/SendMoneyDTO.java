package com.mergen.banksystem.person.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SendMoneyDTO {
    private String tckno;
    private String password;
    private String receiverTckno;
    private Integer amount;

    public SendMoneyDTO(@JsonProperty("tckno") String tckno,
                       @JsonProperty("password") String password,
                       @JsonProperty("receiverTckno") String receiverTckno,
                       @JsonProperty("amount") Integer amount) {
        this.tckno = tckno;
        this.password = password;
        this.receiverTckno = receiverTckno;
        this.amount = amount;
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

    public String getReceiverTckno() {
        return receiverTckno;
    }

    public void setReceiverTckno(String receiverTckno) {
        this.receiverTckno = receiverTckno;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
