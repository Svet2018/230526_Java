import java.util.*;

public class Noutbook {
    /*Подумать над структурой класса Ноутбук для магазина техники -
    выделить поля и методы. Реализовать в java.
    Создать множество ноутбуков.
    Написать метод, который будет запрашивать у пользователя критерий (или критерии)
    фильтрации и выведет ноутбуки, отвечающие фильтру.
    Критерии фильтрации можно хранить в Map.
    Например: “Введите цифру, соответствующую необходимому критерию:
    1 - ОЗУ
    2 - Объем ЖД
    3 - Операционная система
    4 - Цвет …
    Далее нужно запросить минимальные значения для указанных критериев -
    сохранить параметры фильтрации можно также в Map.
    Отфильтровать ноутбуки из первоначального множества и вывести проходящие по условиям.
*/


    private String nameModel;
    private int computerRAM;
    private int hardDiskCapacity;
    private String operatingSystem;
    private String colorModel;


    public Noutbook(String nameModel, int computerRAM, int hardDiskCapacity, String operatingSystem) {
        this.nameModel = nameModel;
        this.computerRAM = computerRAM;
        this.hardDiskCapacity = hardDiskCapacity;
        this.operatingSystem = operatingSystem;
        colorModel = "any color";
    }
    public Noutbook(String nameModel, int computerRAM, int hardDiskCapacity, String operatingSystem, String colorModel) {
        this.nameModel = nameModel;
        this.computerRAM = computerRAM;
        this.hardDiskCapacity = hardDiskCapacity;
        this.operatingSystem = operatingSystem;
        this.colorModel = colorModel;
    }

    public String getNameModel() {
        return nameModel;
    }

    public int getComputerRAM() {
        return computerRAM;
    }

    public int getHardDiskCapacity() {
        return hardDiskCapacity;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public String getColorModel() {
        return colorModel;
    }

    @Override
    public String toString() {
        return "Модель - " + nameModel + "; RAM - " + computerRAM + "GB; емкость ЖД - " + hardDiskCapacity + "GB" +
                "; Операционная система - " + operatingSystem +
                "; цвет ноутбука - " + colorModel + ".";
    }

    //Метод создает сет ноутбуков
    public static Set<Noutbook> noutbookSet(){
        Noutbook noutbook1 = new Noutbook("hp", 8, 500, "Windows", "grey");
        Noutbook noutbook2 = new Noutbook("Lenovo", 16, 1000, "Linux", "black");
        Noutbook noutbook3 = new Noutbook("Asus", 16, 500, "Windows", "silver");
        Noutbook noutbook4 = new Noutbook("Apple", 8, 500, "macOS", "grey");
        Noutbook noutbook5 = new Noutbook("hp", 16, 500, "Linux", "grey");
        Noutbook noutbook6 = new Noutbook("Acer", 16, 1000, "Linux", "pink");
        Noutbook noutbook7 = new Noutbook("Lenovo", 16, 1000, "Windows", "white");

        Set<Noutbook> noutbooks = new HashSet<>();
        noutbooks.add(noutbook1);
        noutbooks.add(noutbook2);
        noutbooks.add(noutbook3);
        noutbooks.add(noutbook4);
        noutbooks.add(noutbook5);
        noutbooks.add(noutbook6);
        noutbooks.add(noutbook7);

        return noutbooks;
    }

    //Метод печатает сет ноутбуков
    public static void printNoutbooks(Set<Noutbook> noutbooks){
        Set<Noutbook> noutbooksSet = new HashSet<>(noutbooks);
        for (Noutbook noutbook : noutbooksSet) {
            System.out.println(noutbook);
        }
    }

    //Метод запрашивает критерии фильтрации ноутбуков
    public static List filterNoutbooks(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите цифру, соответствующую необходимому критерию:\n" +
                "Если требуется несколько критериев, введите цифры, ЧЕРЕЗ ПРОБЕЛ:\n" +
                "    1 - ОЗУ\n" +
                "    2 - Объем ЖД\n" +
                "    3 - Операционная система\n" +
                "    4 - Цвет ");
        System.out.print("> ");
        String str = scanner.nextLine().trim().toLowerCase();
        List<String> arrList = List.of(str.split(" "));
        return arrList;
    }

    //Метод запрашивающий параметры ноутбука у пользователя
    public static Map <String, String> printInfo(List list){
        Map<String, String> map = new HashMap<>();
        List<String> arrList = list;
        for (int i = 0; i < list.size(); i++){
            if (arrList.get(i).equals("1")){
                System.out.println("Введите минимальное значение ОЗУ");
                Scanner scanner = new Scanner(System.in);
                String strOzu = scanner.nextLine();
                map.put("1", strOzu);
            }else  map.put("1", "8");
            if (arrList.get(i).equals("2")){
                System.out.println("Введите минимальное значение объема ЖД");
                Scanner scanner = new Scanner(System.in);
                String strZd = scanner.nextLine();
                map.put("2", strZd);
            } else  map.put("2", "500");
            if (arrList.get(i).equals("3")){
                System.out.println("Введите интересующую операционную систему");
                Scanner scanner = new Scanner(System.in);
                String strOS = scanner.nextLine().toLowerCase();
                map.put("3", strOS);
            } else  map.put("3", "любой".toUpperCase());
            if (arrList.get(i).equals("4")){
                System.out.println("Введите интересующий цвет ноутбука");
                Scanner scanner = new Scanner(System.in);
                String color = scanner.nextLine().toLowerCase();
                map.put("4", color);
            } else  map.put("4", "любой".toUpperCase());
        }
        System.out.println("map " + map);
        return map;
    }

    //Метод создает ноутбук с минимальными (дефолтными) параметрами запроса пользователя
    public static Noutbook mapHashset (Map<String, String> map){
        Map<String, String> mapNew = new HashMap<>(map);
        //Set<Noutbook> myNout = new HashSet<>();
        Noutbook noutbook = new Noutbook("любой".toUpperCase(), Integer.parseInt(mapNew.get("1")), Integer.parseInt(mapNew.get("2")), mapNew.get("3").toUpperCase(), mapNew.get("4"));
        //System.out.println("System.out.println(noutbook) " + noutbook);
        //myNout.add(noutbook);
        System.out.println(noutbook);
        return noutbook;
    }

    //Метод сравнивает ноутбуки с параметрами пользователя
    public static Set<Noutbook> noutbooksPrint (Set<Noutbook> noutbook, Noutbook myNoutbook){
        Set<Noutbook> noutbookNew = new HashSet<>(noutbook);
        Noutbook noutbookMy = myNoutbook;

        Iterator<Noutbook> iterator = noutbookNew.iterator();
        {
           Noutbook noutbooks = iterator.next();
           if (noutbooks.getComputerRAM() <= noutbookMy.getComputerRAM()) {
                    noutbookNew.remove(noutbooks);
                }
            if (noutbooks.getHardDiskCapacity() <= noutbookMy.getHardDiskCapacity()) {
                noutbookNew.remove(noutbooks);
            }
            if (noutbooks.getOperatingSystem().equals(noutbookMy.getOperatingSystem())) {
                noutbookNew.remove(noutbooks);
            }
            if (noutbooks.getColorModel().equals(noutbookMy.getColorModel())) {
                noutbookNew.remove(noutbooks);
            }
        }
        return noutbookNew;
    }

    //Метод отсеивающий ноутбук с пользовательскими параметрами
//    public static Set<Noutbook> noutbooksPrint (Set<Noutbook> noutbook, Map<String, String> map){
//        Set<Noutbook> noutbookNew = new HashSet<>(noutbook);
//        Map<String, String> mapNew = map;
//
//        Iterator<Noutbook> iterator = noutbookNew.iterator();
//        {
//           Noutbook noutbooks = iterator.next();
//
//            if (mapNew.containsKey("1")) {
//                if (noutbooks.getComputerRAM() <= Integer.parseInt(mapNew.get("1"))) {
//                    noutbookNew.remove(noutbooks);
//                }
//            }
//            if (mapNew.containsKey("2")) {
//                if (noutbooks.getHardDiskCapacity() <= Integer.parseInt(mapNew.get("2"))) {
//                    noutbookNew.remove(noutbooks);
//                }
//            }
//            if (mapNew.containsKey("3")) {
//                if (noutbooks.getOperatingSystem().equals(mapNew.get("3"))) {
//                    noutbookNew.remove(noutbooks);
//                }
//            }
//            if (mapNew.containsKey("4")) {
//                if (noutbooks.getColorModel().equals(mapNew.get("4"))) {
//                    noutbookNew.remove(noutbooks);
//                }
//            }
//        }
//        return noutbookNew;
//    }

    //метод выводит ноутбук с интересующими пользователя параметрами
//    public static Set<Noutbook> noutbooksRemove (Set<Noutbook> noutbook1, Set <Noutbook> noutbook2) {
//        Set <Noutbook> noutbookOld = new HashSet<>(noutbook1);
//        Set <Noutbook> noutbookNew = new HashSet<>(noutbook2);
//        noutbookOld.removeAll(noutbookNew);
//        if (!noutbookOld.isEmpty()){
//            printNoutbooks(noutbookOld);
//        }else System.out.println("По Вашим параметрам ноутбуки не найдены");
//
//        return noutbookOld;
//    }



}

