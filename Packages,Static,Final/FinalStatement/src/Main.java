public class Main {

    public static void main(String[] args) {
//	    SomeClass one = new SomeClass("One");
//        SomeClass Two = new SomeClass("Two");
//        SomeClass Three = new SomeClass("Three");
//
//        System.out.println(one.getInstanceNumber());
//        System.out.println(Two.getInstanceNumber());
////        one.instanceNumber=4;
//        System.out.println(Math.PI);

//        int pw = 674312;
//        Password password = new ExtendedPassword(pw);
//        password.storePassword();
//        password.letMeIn(10);
//        password.letMeIn(674312);
//        password.letMeIn(147945);
//        password.letMeIn(-1);
//        password.letMeIn(674312);
        System.out.println("Main method called");
        SIB sib = new SIB();

        sib.somemethod();
        System.out.println("The value of owner is " + SIB.owner);
        SIB sib2 = new SIB();
        System.out.println("New sib Instance created");
        sib2.somemethod();
        System.out.println("The value of owner is " + SIB.owner);
    }
}
