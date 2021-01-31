package ru.aristovo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.aristovo.JSONPack.Company;
import ru.aristovo.JSONPack.Stocks;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        SimpleDateFormat simple = new SimpleDateFormat("dd.MM.yyyy");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        ObjectMapper mapper = new ObjectMapper();
        mapper.setDateFormat(simple);


        List<Company> companyList = mapper.readValue(new File("orgs.json"), new TypeReference<List<Company>>(){});

        for (Company c:companyList) {
            System.out.println(c.getCompany_name() + " " + c.getDate_foundation());
            for (Stocks s: c.getStocks()) {
                System.out.println(s.getOwner());
            }
        }

    }
}
