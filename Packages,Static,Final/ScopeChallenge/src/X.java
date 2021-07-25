import java.util.Scanner;

public class X {

    private int x;


    public X(Scanner x) {
        System.out.print("Please enter a Number: ");
        this.x = x.nextInt();
    }

    public void x() {
        for (int x=1;x<=12;x++) {
            System.out.println(this.x + " times "+ x + " equals to " + x * this.x);
        }

    }

}
