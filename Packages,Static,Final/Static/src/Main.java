public class Main {

    public static int multiplier = 7;
    public static void main(String[] args) {
        StaticTest firstInstance = new StaticTest("1st Instance");
//        System.out.println(firstInstance.getName() + " is Instance Number "+ firstInstance.getNumInstances());
        System.out.println(firstInstance.getName() + " is Instance Number "+ StaticTest.getNumInstances());

        StaticTest secondInstance = new StaticTest("2nd Instance");
//        System.out.println(secondInstance.getName() + " is Instance Number "+ secondInstance.getNumInstances());
        System.out.println(secondInstance.getName() + " is Instance Number "+ StaticTest.getNumInstances());
//
//        StaticTest thirdInstance = new StaticTest("3rd Instance");
////        System.out.println(thirdInstance.getName() + " is Instance Number "+ thirdInstance.getNumInstances());
//        System.out.println(thirdInstance.getName() + " is Instance Number "+ StaticTest.getNumInstances());

        int answer =  multiply(5);
        System.out.println("Answer is " + answer);
    }

    public static int multiply(int number) {
        return number*multiplier;
    }

}
