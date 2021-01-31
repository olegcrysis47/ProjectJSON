package ru.aristovo.application;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.aristovo.application.JSONpack.Company;
import ru.aristovo.application.JSONpack.Stock;
import ru.aristovo.application.streamWork.MethodsWorkStream;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        List<Company> company = mapper
                .readValue(new File("company.json"), new TypeReference<List<Company>>() {});

        // тестируем метод MethodsWorkStream.viewCompany(List<Company> list)
        System.out.println("Задача № 1. Выводим название компании и дату ее основания:");
        MethodsWorkStream.viewCompany(company);
        System.out.println("----------------------------------------------------------");

        /*
        //Блок тестирования
        int i = 1;
        for (Company c: company) {
            System.out.println("------------Компания № " + i);
            System.out.println(c.getCompanyName());
            System.out.println(c.getAddress());
            System.out.println(c.getPhoneNumber());
            System.out.println(c.getInn());
            System.out.println(c.getOgrn());
            System.out.println(c.getDateFoundation());
            System.out.println("--------Акции компании");
            i++;

            int j = 1;
            for (Stock s: c.getStocks()) {
                System.out.println("----- Акция № " + j);
                System.out.println(s.getCode());
                System.out.println(s.getExpirationDate());
                System.out.println(s.getOwner());
                System.out.println("-----------------------------------------");
                j++;
            }
            System.out.println("-----------------------------------------");
        }
        */

    }

}
