package academy.learnprogramming;

public class Main {

    public static void main(String[] args) {

        boolean gameOVer =true;
        int score = 800;
        int levelCompleted = 5;
        int bonus = 100;

        if(score <5000 && score > 1000)
        {
            System.out.println("Your Score Was Less Than 5000 But Greater Than 1000.");
        }else if(score <1000) {
            System.out.println("Your Score Was Less Than 1000");
        }else {
            System.out.println("Got Here");
        }

        if(gameOVer==true) {
            int finalscore = score + (levelCompleted*bonus);
            System.out.println("Your Final Score Was "+finalscore);
        }

        score = 10000;
        levelCompleted = 8;
        bonus = 200;

        if(gameOVer)    {
            int finalscore = score + (levelCompleted*bonus);
            System.out.println("Your Changed Final Score is "+finalscore);
        }
    }
}
