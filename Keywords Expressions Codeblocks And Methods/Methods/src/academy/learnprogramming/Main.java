package academy.learnprogramming;

public class Main {

    public static void main(String[] args) {
        boolean gameOver=true;
        int score=800;
        int levelCompleted=5;
        int bonus=100;
        int highScore;
        highScore = calculateScore(gameOver,score,levelCompleted,bonus);
        System.out.println("Your Final Score Was "+highScore);

        int highScoreResult = calculateHighScorePosition(1000);
        displayPlayerHighScorePosition("Gilbert",highScoreResult);
    }


    public static int calculateScore(boolean gameOver,int score,int levelCompleted,int bonus) {

        if(gameOver) {
            int finalScore = score + (levelCompleted*bonus);
            finalScore+=2000;
            return finalScore;
        }
            return -1;
        //we can also write else {
        //return -1;
        //}

    }

    public static void displayPlayerHighScorePosition(String playerName,int playerPosition) {
        System.out.println(playerName + " Managed To Get Into Position " + playerPosition + " On The High Score Table");
    }

    public static int calculateHighScorePosition(int score) {
//        if(score>=1000)
//            return 1;
//        else if(score >=500)
//            return 2;
//        else if (score >=100)
//            return 3;
//
//            return 4;

        int position = 4;
        if(score >=1000)
            position = 1;
        else if(score >=500)
            position = 2;
        else if(score >=100)
            position = 3;

        return position;
    }

}
