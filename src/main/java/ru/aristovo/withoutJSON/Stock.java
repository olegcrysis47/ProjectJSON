package ru.aristovo.withoutJSON;

import java.time.LocalDate;

public class Stock {

    private Code code;
    private LocalDate expiration_date;
    private String owner;

    //public Stock() {}

    public Stock(Code code, LocalDate expiration_date, String owner) {
        this.code = code;
        this.expiration_date = expiration_date;
        this.owner = owner;
    }

    public Code getCode() {
        return code;
    }

    public void setCode(Code code) {
        this.code = code;
    }

    public LocalDate getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(LocalDate expiration_date) {
        this.expiration_date = expiration_date;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
