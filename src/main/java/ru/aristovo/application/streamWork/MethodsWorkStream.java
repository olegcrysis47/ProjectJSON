package ru.aristovo.application.streamWork;

import ru.aristovo.application.JSONpack.Code;
import ru.aristovo.application.JSONpack.Company;
import ru.aristovo.application.JSONpack.Stock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class MethodsWorkStream {

    /*
    - Вывести все имеющиеся компании в формате «Краткое название» – «Дата основания 17/01/98»;
     */

    public static void viewCompany(List<Company> list) {

        DateTimeFormatter formatterNew = DateTimeFormatter.ofPattern("dd/MM/yy");
        DateTimeFormatter formatterOld = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        list.stream().forEach((c) -> System.out.println("Название компании " +
                c.getCompanyName() +
                " - Дата основания " +
                LocalDate.parse(c.getDateFoundation(), formatterOld).format(formatterNew)));

    }

    /*
    - Вывести все ценные бумаги (их код, дату истечения и полное название организации-владельца),
    которые просрочены на текущий день, а также посчитать суммарное число всех таких бумаг;
     */

    public static void viewExpiredStock(List<Company> list) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        System.out.println("Просроченные акции:");
        list.stream()
                .forEach((c) -> c.getStocks()
                        .stream()
                        .filter((s) -> LocalDate.parse(s.getExpirationDate(), formatter).isBefore(LocalDate.now()))
                        .forEach((s) -> System.out.println(
                                "Код валюты " + s.getCode() + " дата истечения " + s.getExpirationDate() +
                                        " текущий владелец " + c.getCompanyName()
                        )));


    }


    /*
    - На запрос пользователя в виде даты «ДД.ММ.ГГГГ», «ДД.ММ.ГГ», «ДД/ММ/ГГГГ» и «ДД/ММ/ГГ» вывести название
    и дату создания всех организаций, основанных после введенной даты;
    */

    public static void viewCompanyByDate(List<Company> list) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите дату:");
        String enterDate = reader.readLine();
        reader.close();

        String[] str = enterDate.split("\\W");

        int day = Integer.parseInt(str[0]);
        int mouth = Integer.parseInt(str[1]);
        int year = Integer.parseInt(str[2]);;
        if (year < 100) {
            if (year < 70) year += 2000;
            else if (year >= 70) year += 1900;
        }

        LocalDate date = LocalDate.of(year, mouth, day);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        System.out.println("Компании которые основаны после " + date);
        list.stream()
                .filter((c) -> LocalDate.parse(c.getDateFoundation(),formatter).isAfter(date))
                .forEach((c) -> System.out.println(c.getCompanyName() + " " + c.getDateFoundation()));

    }

    /*
    - На запрос пользователя в виде кода валюты, например EU, USD, RUB и пр. выводить id и коды ценных бумаг,
    использующих заданную валюту.
     */

    public static void viewStockByCode(List<Company> list) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите код валюты акции");
        String enterCode = reader.readLine().toUpperCase();
        reader.close();

        Code code;
        try {
            code = Code.valueOf(enterCode);
        } catch (Exception exception) {
            System.out.println("Некорректный код валюты!");
            return;
        }

        System.out.println("Акции по запрошенной валюте " + enterCode.toUpperCase() + ":");

        list.stream()
                .forEach((c) -> c.getStocks()
                .stream()
                        .filter((s) -> s.getCode().equals(code))
                        .forEach((s) -> System.out.println(s.getCode() + " " + s.getOwner())));


    }

}
