package com.example.series;

public class Series {
    public static long nSum(int n) {
        return (n * ( n + 1 ))/2;
    }

    public static long factorial(int n) {
        if(n==0)
            return 0;
        long fact = 1;
        long total=0;
        for(int i=1;i<=n;i++) {
            fact =fact*i;
            total+=fact;
        }
        return fact;
    }

    public static void fibonacci(int n) {
        int firstTerm=0;
        int secondTerm=1;

//        if(n==0)
//            return 0;
//        else if(n==1)
//            return 1;
        for(int i=0;i<=n;i++) {
            System.out.print(firstTerm + ", ");
            int nextTerm = firstTerm+secondTerm;
            firstTerm=secondTerm;
            secondTerm=nextTerm;
        }
//        System.out.println(firstTerm + ", ");
//        return firstTerm;
    }



}
