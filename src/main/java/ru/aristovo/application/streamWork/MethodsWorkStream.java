package ru.aristovo.application.streamWork;

import ru.aristovo.application.JSONpack.Company;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

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

    - На запрос пользователя в виде даты «ДД.ММ.ГГГГ», «ДД.ММ.ГГ», «ДД/ММ/ГГГГ» и «ДД/ММ/ГГ» вывести название
    и дату создания всех организаций, основанных после введенной даты;

    - На запрос пользователя в виде кода валюты, например EU, USD, RUB и пр. выводить id и коды ценных бумаг,
    использующих заданную валюту.
     */

}
