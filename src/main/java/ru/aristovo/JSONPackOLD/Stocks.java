package ru.aristovo.JSONPack;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Stocks {

    @JsonProperty("expiration_date")
    private LocalDate expirationDate;
    private String owner;

    private static DateTimeFormatter defaultDateFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public String getExpirationDate() {
        return expirationDate.format(defaultDateFormat);
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = LocalDate.parse(expirationDate, defaultDateFormat);
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
