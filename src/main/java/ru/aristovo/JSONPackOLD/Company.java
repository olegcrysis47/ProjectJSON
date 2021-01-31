package ru.aristovo.JSONPackOLD;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;


public class Company {

    @JsonProperty("company_name")
    private String companyName;
    private String address;
    @JsonProperty("date_foundation")
    private LocalDate dateFoundation;
    private List<Stocks> stocks;

    private static DateTimeFormatter defaultDateFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public Company() {};

    public String getDateFoundation() {
        return dateFoundation.format(defaultDateFormat);
    }

    public void setDateFoundation(String date) {
        this.dateFoundation = LocalDate.parse(date, defaultDateFormat);
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Stocks> getStocks() {
        return stocks;
    }

    public void setStocks(List<Stocks> stocks) {
        this.stocks = stocks;
    }
}
