package ru.aristovo.JSONPackOLD;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        ObjectMapper mapper = new ObjectMapper();


        List<Company> companyList = mapper.readValue(new File("orgsOLD.json"), new TypeReference<List<Company>>(){});

        for (Company c:companyList) {
            System.out.println(c.getCompanyName() + " " + c.getDateFoundation());
            for (Stocks s: c.getStocks()) {
                System.out.println(s.getOwner() + " " + s.getExpirationDate());
            }
        }

    }
}
