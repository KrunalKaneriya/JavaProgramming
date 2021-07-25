package academy.learnprogramming;

public class Main {

    public static void main(String[] args) {
//        int count =1;
//        while (count!=6) {
//            System.out.println("Count Value is "+count);
//            count++;
//        }
//
//        count=1;
//        while (true) {
//            if(count==6) {
//               break;
//            }
//            System.out.println("Count Value is "+count);
//            count++;
//        }
//
//        count = 6;
//        do {
//            System.out.println("Count Value is "+count);
//            count++;
//
//            if(count>100)
//                break;
//        }while (count!=6);
        int value = 5;
        int finish = 20;
        int counter=0;
        int sum=0;


        while(value<=finish) {
            value++;
            if(!isEvenNumber(value)) {
                continue;
            }
            counter++;
            System.out.println("Even Number: "+value);
            if(counter>=5) {
                break;
            }

        }

        System.out.println("Total Even Numbers Found: "+counter);



    }

    public static boolean isEvenNumber (int value) {
        return ((value%2)==0);
    }

}
