package academy.learnprogramming;

public class Main {

    public static void main(String[] args) {

        int sum=0;
        int counter=0;
        for(int i=1;i<=1000;i++) {
            if(i%3==0 && i%5==0) {
                System.out.println("The Number Which Is Divisible By Both 3 And 5 is "+i);
                counter++;
                sum+=i;
            }
            if(counter==5) {
                break;
            }
        }
        System.out.println("The Sum Of Numbers Divisible By 3 And 5 Is "+sum);
    }

}
