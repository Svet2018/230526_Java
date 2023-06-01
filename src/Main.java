import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println();

        Set<Noutbook> noutbooks = Noutbook.noutbookSet(); //Создание ноутбуков из магазина

        System.out.println("Ноутбуки в наличии: ");//Ноутбуки имеющиеся в магазине
        Noutbook.printNoutbooks(noutbooks);//Вывод на экран магазинных ноутбуков
        System.out.println();

        List<String> list = Noutbook.filterNoutbooks();//Выводится на экран запрос на параменты пользователя на ноутбуки
        Map<String, String> map = Noutbook.printInfo(list);//Вводятся параметры пользователя
        System.out.println();

        System.out.println("Ноутбуки в наличии: ");
        Noutbook.printNoutbooks(noutbooks);//Выводятся на экран ноутбуки в магазине
        System.out.println();

        System.out.println("Параметры ноутбука по Вашим требованиям (минимальные параметры): ");
        Noutbook myNout = Noutbook.mapHashset(map);//Выводятся на экран параметры ноутбука пользователя
        System.out.println();

        System.out.println("Вашим требованиям соответствуют следующие ноутбуки: ");
        Set<Noutbook> noutbooks1 = Noutbook.noutbooksPrint(noutbooks, myNout);//Сравниваются ноутбуки в магазине с запросом пользователя
        Noutbook.printNoutbooks(noutbooks1);//Выводятся на экран соответствующие требованиям ноутбуки



//        System.out.println("Ноутбуки соответсвующие Вашим требованиям: ");
//        Set <Noutbook> finalNouts = Noutbook.noutbooksRemove(noutbooks, noutbooks1);
//        System.out.println();

    }
}