package ru.aristovo.withoutJSON;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NewMain {

    public static void main(String[] args) {
        List<Organization> orgs = new ArrayList<Organization>();

        orgs.add(new Organization("UNIT",
                "Perm, Komsomolsky st., 42",
                "+7-495-123-33-33",
                "3128123456",
                "1103254016216",
                LocalDate.of(2005,2,5),
                Arrays.asList(
                        new Stock(Code.EU, LocalDate.of(2021,5,15), "Notebook"),
                        new Stock(Code.USD, LocalDate.of(2019,4,16), "Facebook"),
                        new Stock(Code.RUB, LocalDate.of(2021,9,23), "RUS-Company"))));

        orgs.add(new Organization("SUN",
                "Moscow, Leninskiy pr., 113",
                "+7-495-987-11-11",
                "1234567890",
                "123456789101",
                LocalDate.of(2003,8,15),
                Arrays.asList(
                        new Stock(Code.USD, LocalDate.of(2015,11,11), "Facebook"),
                        new Stock(Code.USD, LocalDate.of(2022,6,29), "Microsoft"),
                        new Stock(Code.EU, LocalDate.of(2018,9,12), "London LTD"))));

        orgs.add(new Organization("ORACLE",
                "Moscow, Kievskoe shosse, 6",
                "+1-800-321-55-55",
                "9876543210",
                "9876543210222",
                LocalDate.of(2020,1,27),
                Arrays.asList(
                        new Stock(Code.RUB, LocalDate.of(2021,12,11), "Zavod"),
                        new Stock(Code.RUB, LocalDate.of(2020,3,3), "Unit"),
                        new Stock(Code.USD, LocalDate.of(2020,12,31), "Washington"))));

        orgs.add(new Organization("GOOD-MAN",
                "Belgorod, Lenina st, 2",
                "+2-123-123-99-99",
                "1598753246",
                "1236547895147",
                LocalDate.of(2017,9,14),
                Arrays.asList(
                        new Stock(Code.EU, LocalDate.of(2020,1,30), "Xerox"),
                        new Stock(Code.USD, LocalDate.of(2025,5,15), "MSI"),
                        new Stock(Code.RUB, LocalDate.of(2021,6,12), "Acer"))));

        orgs.add(new Organization("CHRISTOPHER",
                "Vladivostok, Ermolaeva street, 1",
                "+3-147-258-36-96",
                "5858252536",
                "5858252536951",
                LocalDate.of(2012,3,9),
                Arrays.asList(
                        new Stock(Code.EU, LocalDate.of(2015,2,2), "Acer"),
                        new Stock(Code.EU, LocalDate.of(2020,5,5), "Java"),
                        new Stock(Code.RUB, LocalDate.of(2022,5,31), "Community"))));
        //чисто для проверки списка
        /*
        int i = 1;
        for (Organization o: orgs) {
            System.out.println("Организация номер № " + i);
            System.out.println(o.getCompany_name());
            System.out.println(o.getAddress());
            System.out.println(o.getPhone_number());
            System.out.println(o.getInn());
            System.out.println(o.getOgrn());
            System.out.println(o.getDate_foundation());
            System.out.println("---АКЦИИ---");
            for (Stock s : o.getStocks()) {

                System.out.println(s.getCode());
                System.out.println(s.getExpiration_date());
                System.out.println(s.getOwner());

            }
            i++;
        }*/



        /*
        - Вывести все имеющиеся компании в формате «Краткое название» – «Дата основания 17/01/98»;
         */
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        //System.out.println(simpleDateFormat.format(orgs.get(0).getDate_foundation()));
        orgs.stream().
                forEach((o) ->
                        System.out.println(o.getCompany_name() + " - Дата основания " +
                                o.getDate_foundation().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));

        System.out.println("----------------------------------------------");


        /*
        - Вывести все ценные бумаги (их код, дату истечения и полное название организации-владельца),
        которые просрочены на текущий день, а также посчитать суммарное число всех таких бумаг;
         */

        List<List<Stock>> st = orgs.stream().map((o) -> o.getStocks()).collect(Collectors.toList());
        st.stream().forEach((s) -> s.stream().filter((d) -> d.getCode() == Code.EU).forEach((g) -> System.out.println(g.getOwner())));

        System.out.println("----------------------------------------------");
        orgs.stream().forEach((s) -> s.getStocks().stream().filter((d) -> d.getCode() == Code.RUB).forEach((d) -> System.out.println(d.getOwner())));


        LocalDate dateNow = LocalDate.now();
        LocalDate date = LocalDate.of(2021, 5,31);
        System.out.println(dateNow.isAfter(date));


    }
}
