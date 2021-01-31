package ru.aristovo.JSONPack;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


public class Company {

    private String company_name;
    private String address;
    private LocalDate date_foundation;
    private List<Stocks> stocks;

    public Company() {};

    public LocalDate getDate_foundation() {
        return date_foundation;
    }

    public void setDate_foundation(LocalDate date_foundation) {
        this.date_foundation = date_foundation;
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

    public List<Stocks> getStocks() {
        return stocks;
    }

    public void setStocks(List<Stocks> stocks) {
        this.stocks = stocks;
    }
}
