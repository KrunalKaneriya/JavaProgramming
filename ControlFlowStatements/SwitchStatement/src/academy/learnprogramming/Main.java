package academy.learnprogramming;

public class Main {

    public static void main(String[] args) {
//	int value = 1;
//	if(value==1) {
//        System.out.println("Value is 1");
//    } else if(value == 2) {
//        System.out.println("Value is 2");
//    } else {
//        System.out.println("Value is not 1 or 2");
//    }

//	int switchValue = 5;
//	switch (switchValue) {
//        case 1:
//            System.out.println("The Value is 1");
//            break;
//        case 2:
//            System.out.println("The Value is 2");
//            break;
//        case 3:
//            System.out.println("The Value is 3");
//            break;
//        case 4: case 5: case 6:
//            System.out.println("The Value is 4, 5 or 6");
//            System.out.println("Actually It Was a "+switchValue);
//            break;
//        default:
//            System.out.println("The Value is Unknown");
//            break;
//	}

        char switchChar = 'Z';
        switch (switchChar) {
            case 'A':
                System.out.println("The Character is A");
                break;
            case 'B':
                System.out.println("The Character is B");
                break;
            case 'C':
                System.out.println("The Character is C");
                break;
            case 'D': case 'E':
                System.out.println("The Character is "+switchChar);
                break;
            default:
                System.out.println("The Character is Unknown And It is Actually " + switchChar);
                break;
        }

        String month = "January";
        switch (month.toLowerCase()) {
            case "january":
                System.out.println("The Month Is Jan");
                break;
            case "February":
                System.out.println("The Month is Feb");
                break;
        }
    }


}

