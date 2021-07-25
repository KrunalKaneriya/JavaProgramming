import javax.swing.*;
import java.util.ArrayList;

class intclass {
    private int value;

    public intclass(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

public class Main {

    public static void main(String[] args) {
	String[] strArray = new String[10];
	int[] intArray = new int[10];


	ArrayList<String> Arraystringlist = new ArrayList<String>();
	Arraystringlist.add("Krunal");

	ArrayList<intclass> Arraylistint = new ArrayList<intclass>();
	Arraylistint.add(new intclass(24));

//	Integer intValue = new Integer(54);
//	Double doubleValue = new Double(12.145);

//	ArrayList<Integer>integerList = new ArrayList<Integer>();
//
//	for(int i=0;i<10;i++) {
//	    integerList.add(Integer.valueOf(i)); //This is autoboxing
//    }
//
//	for (int i=0;i<10;i++) {
//        System.out.println(i + " --> " + integerList.get(i).intValue()); //This is unboxing
//    }
//    }
//
//    Integer myvalue = Integer.valueOf(56);
//    int myInt = myvalue; //myInt = myvalue.intValue();

    ArrayList<Double>myDoubleValues = new ArrayList<Double>();
    for (double dbl = 0.0;dbl<=10.0;dbl+=0.5) {
        myDoubleValues.add(Double.valueOf(dbl));
    }

    for (int i=0;i<=20;i++) {
        System.out.println( i + " --> "+ myDoubleValues.get(i).doubleValue());
    }
}
}
