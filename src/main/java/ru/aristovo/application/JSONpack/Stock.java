package ru.aristovo.application.JSONpack;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Stock {

    private Code code;                  // код валюты акций
    @JsonProperty("expiration_date")
    private LocalDate expirationDate;   // дата истечения акции
    private String owner;               // владелец, выпустивший акцию

    // переменная для формата даты
    private static DateTimeFormatter defaultDateFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    // геттеры и сеттеры
    public Code getCode() {
        return code;
    }

    public void setCode(Code code) {
        this.code = code;
    }

    public String getExpirationDate() {
        return expirationDate.format(defaultDateFormat);
    }

    public void setExpirationDate(String date) {
        this.expirationDate = LocalDate.parse(date, defaultDateFormat);
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}