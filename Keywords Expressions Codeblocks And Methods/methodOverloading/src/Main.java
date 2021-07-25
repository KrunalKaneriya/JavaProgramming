public class Main {
    public static void main(String[] args) {

//        int newScore = calculateScore("Krunal",500);
////        System.out.println("New Score is "+newScore);
//        calculateScore(newScore);
//        calculateScore();


//    public static int calculateScore(String playerName,int score) {
//        System.out.println("Player " + playerName + " scored " + score + " points ");
//        return score*10 ;
//    }
//
//    public static int calculateScore(int score) {
//        System.out.println("Unnamed Player" + " scored " + score + " points ");
//        return score*1000 ;
//    }
//
//    public static int calculateScore() {
//        System.out.println("No Player name ,no player score." );
//        return 0;

        double centimeters = calcFeetAndInchesToCentimeters(-157);

        if(centimeters<0) {
            System.out.println("Invalid Parameters");
        }
    }

     public static double calcFeetAndInchesToCentimeters (double feet,double inches) {

         if ((feet < 0) || (inches < 0 || inches > 12)) {
             System.out.println("Invalid Feet Or Inches Parameters");
             return -1;
         }
         else {
             double feetAndInchestoCm = (feet * 30.48) + (inches * 2.54);
             System.out.println(feet + " Feet ,"+ inches + " Inches = "+feetAndInchestoCm + " Centimeters");
             return feetAndInchestoCm;
         }
     }

        public static double calcFeetAndInchesToCentimeters(double inches) {
            if(inches<0) {
                return -1;
            }
            else {
                double feet = inches / 12;
                double randomCentimeter = calcFeetAndInchesToCentimeters(feet, inches);
                System.out.println("The Conversion of Inches: " + inches + " is feet: " + feet);
                return randomCentimeter;
            }
        }

}

