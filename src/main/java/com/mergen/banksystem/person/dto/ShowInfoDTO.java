package com.mergen.banksystem.person.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ShowInfoDTO {
    private String tckno;
    private String password;

    public ShowInfoDTO(@JsonProperty("tckno") String tckno,
                        @JsonProperty("password") String password) {
        this.tckno = tckno;
        this.password = password;
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
}
