package ru.aristovo.application.JSONpack;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Company {

    @JsonProperty("company_name")
    private String companyName;         // наименование компании
    private String address;             // адрес компании
    @JsonProperty("phone_number")
    private String phoneNumber;         // телефон компании
    private String inn;                 // ИНН компании
    private String ogrn;                // ОГРН компании
    @JsonProperty("date_foundation")
    private LocalDate dateFoundation;   // дата основания компании
    private List<Stock> stocks;         // список акций во владении

    private static DateTimeFormatter defaultDateFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    // геттеры и сеттеры
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getOgrn() {
        return ogrn;
    }

    public void setOgrn(String ogrn) {
        this.ogrn = ogrn;
    }

    public String getDateFoundation() {
        return dateFoundation.format(defaultDateFormat);
    }

    public void setDateFoundation(String date) {
        this.dateFoundation = LocalDate.parse(date, defaultDateFormat);
    }

    public List<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }
}
