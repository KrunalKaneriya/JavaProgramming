public class Main {

    public static void main(String[] args) {

        Printer p1 = new Printer(69,true);
//        p1.pagesPrinting(50);
//        p1.pagesPrinting(10);
//        p1.pagesPrinting(5);
//        p1.pagesPrinting(25);
        p1.fillToner(4);
        p1.pagesPrinting(5);
        p1.pagesPrinting(15);
        p1.setTonerLevel(6);
        System.out.println(p1.getPagesPrinted());
        p1.setDuplexPrinter(false);
        p1.pagesPrinting(20);

        System.out.println(p1.getTonerLevel());

    }
}
