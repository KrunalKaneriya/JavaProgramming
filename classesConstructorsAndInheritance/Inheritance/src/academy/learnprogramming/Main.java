package academy.learnprogramming;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Animal animal = new Animal("Animal",1,1,5,5);
//
//        Dog dog = new Dog("Yorkie",8,20,2,4,1,20,"Long Silky");
//        dog.eat();
////        dog.walk();
////        dog.run();

        System.out.println("Enter The Fish Name:");
        String fishname = scanner.nextLine();
        System.out.println("Enter The Fish Size: ");
        int fishsize = scanner.nextInt();
        System.out.println("Enter The Fish Weight: ");
        int fishweight = scanner.nextInt();

        Animal fish1 = new fish (fishname,fishsize,fishweight,2,2,1);

        System.out.println("The Fish Name is: "+ fish1.getName());
        System.out.println("The Fish Size is "+fish1.getSize() + " cm");
        System.out.println("The Fish Weight is " + fish1.getWeight() + " kg");

        scanner.close();
    }
}
