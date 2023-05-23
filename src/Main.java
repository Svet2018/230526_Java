import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println();

        Set<Noutbook> noutbooks = Noutbook.noutbookSet(); //Ноутбуки из магазина

        System.out.println("Ноутбуки в наличии: ");//Ноутбуки в магазине
        Noutbook.printNoutbooks(noutbooks);
        System.out.println();

        List<String> list = Noutbook.filterNoutbooks();
        Map<String, String> map = Noutbook.printInfo(list);
        System.out.println();

        System.out.println("Ноутбуки в наличии: ");
        Noutbook.printNoutbooks(noutbooks);
        System.out.println();

        System.out.println("Параметры ноутбука по Вашим требованиям (минимальные параметры): ");
        Noutbook myNout = Noutbook.mapHashset(map);
        System.out.println();

        System.out.println("Вашим требованиям соответствуют следующие ноутбуки: ");
        Set<Noutbook> noutbooks1 = Noutbook.noutbooksPrint(noutbooks, myNout);
        Noutbook.printNoutbooks(noutbooks1);

        //System.out.println("Ноутбуки не соответствующие требованиям пользователя: ");

        //Set<Noutbook> noutbooks1 = Noutbook.noutbooksPrint(noutbooks, map);//Ноутбуки не соответстующие параметрам пользователя
//        Noutbook.printNoutbooks(noutbooks1);
        System.out.println();

//
//        System.out.println("Ноутбуки соответсвующие Вашим требованиям: ");
//        Set <Noutbook> finalNouts = Noutbook.noutbooksRemove(noutbooks, noutbooks1);
//        System.out.println();

    }
}