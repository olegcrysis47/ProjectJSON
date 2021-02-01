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

    /*
    - На запрос пользователя в виде кода валюты, например EU, USD, RUB и пр. выводить id и коды ценных бумаг,
    использующих заданную валюту.
     */

    public static void viewStockByCode(List<Company> list) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String enterCode = reader.readLine();
        reader.close();

        Code code = null;
        if (enterCode.equalsIgnoreCase("RUB")) code = Code.RUB;
        else if (enterCode.equalsIgnoreCase("USD")) code = Code.USD;
        else if (enterCode.equalsIgnoreCase("EU")) code = Code.EU;

        list.stream().forEach((c) -> c.getStocks().stream().filter((s) -> s.getCode() == Code.EU).forEach((s) -> System.out.println(s.getOwner())));
    }

}
