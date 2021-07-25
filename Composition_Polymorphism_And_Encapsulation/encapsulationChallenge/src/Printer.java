public class Printer {
    private double tonerLevel;
    private int pagesPrinted;
    private boolean isDuplexPrinter;
    public Printer(double tonerLevel, boolean isDuplexPrinter) {
        if(tonerLevel >=0.00 && tonerLevel <=100.00) {
            this.tonerLevel = tonerLevel;
        }
        this.pagesPrinted = 0;
        this.isDuplexPrinter = isDuplexPrinter;
//        System.out.println("Created A New Instance Of Printer Object");
    }

    public void fillToner(double tonerLevel) {
        if(tonerLevel >0.00 && tonerLevel <=100.00) {
            if(this.tonerLevel + tonerLevel >100) {
                System.out.println("Toner Level Exceeds the Limited Amount..");
            } else {
                System.out.println("Filling The Toner To " + tonerLevel);
                this.tonerLevel += tonerLevel;
                System.out.println("The Toner Level is: " + this.tonerLevel + "\n");
            }
        }
        else {
            System.out.println("Enter The Valid Amount Of Toner Level ");
        }
    }

    public void setTonerLevel(double tonerLevel) {
        fillToner(tonerLevel);
    }

    public void setDuplexPrinter(boolean duplexPrinter) {
        isDuplexPrinter = duplexPrinter;
    }

    public void pagesPrinting(int numberOfPages) {

        if(this.tonerLevel >0) {
            this.tonerLevel -= numberOfPages * 0.25;
            if (this.isDuplexPrinter) {
                this.pagesPrinted += (numberOfPages / 2) + (numberOfPages % 2);
                System.out.println("The Pages Are Going To Be Printed Both SIde Because it is Duplex Printer");
                System.out.println("The Pages Are To Be Printed is " + numberOfPages);
                System.out.println("The Total Count Of Printed Pages are: " + this.pagesPrinted + "\n");
            } else {
                this.pagesPrinted += numberOfPages;
                System.out.println("The Pages Are Not Going To Be Printed Both SIdes Because it is not Duplex Printer");
                System.out.println("The Pages Are To Be Printed is " + numberOfPages);
                System.out.println("The Total Count Of Printed Pages are: " + this.pagesPrinted + "\n");
            }
        } else {
            System.out.println("The Toner Level is Very Low. Cannot Continue Printing!!!!!!");
            System.out.println("Do You Want to Fill The Toner?" + "\n");
        }
    }
    public int getPagesPrinted() {
        return this.pagesPrinted;
    }

    public double getTonerLevel() {
        return this.tonerLevel;
    }
}
