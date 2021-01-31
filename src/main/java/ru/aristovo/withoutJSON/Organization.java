package ru.aristovo.withoutJSON;

import java.time.LocalDate;
import java.util.List;

public class Organization {

    private String company_name;
    private String address;
    private String phone_number;
    private String inn;
    private String ogrn;
    private LocalDate date_foundation;
    private List<Stock> stocks;

    //public Organization() {}

    public Organization(String company_name, String address, String phone_number, String inn, String ogrn, LocalDate date_foundation, List<Stock> stocks) {
        this.company_name = company_name;
        this.address = address;
        this.phone_number = phone_number;
        this.inn = inn;
        this.ogrn = ogrn;
        this.date_foundation = date_foundation;
        this.stocks = stocks;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
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

    public LocalDate getDate_foundation() {
        return date_foundation;
    }

    public void setDate_foundation(LocalDate date_foundation) {
        this.date_foundation = date_foundation;
    }

    public List<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }
}
