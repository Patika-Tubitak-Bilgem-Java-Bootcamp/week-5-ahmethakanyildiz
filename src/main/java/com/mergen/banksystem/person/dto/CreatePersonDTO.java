package com.mergen.banksystem.person.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreatePersonDTO {
    private String tckno;
    private String password;
    private Integer birthYear;

    public CreatePersonDTO(@JsonProperty("tckno") String tckno,
                           @JsonProperty("password") String password,
                           @JsonProperty("birthYear") Integer birthYear) {
        this.tckno = tckno;
        this.password = password;
        this.birthYear = birthYear;
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
}
