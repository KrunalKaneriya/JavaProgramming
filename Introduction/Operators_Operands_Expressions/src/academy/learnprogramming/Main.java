package academy.learnprogramming;

public class Main {

    public static void main(String[] args) {

        int result = 1+2; // 1+2=3
        System.out.println(result);
        int previousResult = result;
        System.out.println("Previous Result = " + previousResult);
        result = result-1; // 3-1 = 2
        System.out.println(result);

        result = result*10; // 2*10 = 20
        System.out.println("Result * 10 = " + result);

        result = result/5; // 20/5 = 4
        System.out.println("Result / 5 = "+result);

        result = result%3; // The Remainder Of 4 % 3 = 1
        System.out.println("4 % 3 = " + result);

        //result = result + 1;
        result++;
        System.out.println("Result++ = "+result);

        result--;
        System.out.println("Result-- = "+result);

        result+=2;//result = result + 2
        System.out.println("result +=2 = " + result);

        result*=10;//result = result * 10
        System.out.println("result *=10 = " + result);

        result/=3;//result = result / 2
        System.out.println("result /=3 = " + result);

        result-=2;//result = result - 2
        System.out.println("result -=2 = " + result);
    }
}
