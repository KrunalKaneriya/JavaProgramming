package academy.learnprogramming;

public class Main {

    public static void main(String[] args) {
	getDurationString(590,45);
    }

    public static void getDurationString(int minutes,int seconds) {
        if (minutes < 0 || seconds <0 || seconds >59) {
            System.out.println("Invalid Value.");
        }
        else {
            int hours = minutes/60;
            int mins = minutes%60;
            if(hours<10 && mins<10) {
                System.out.println("HH:0" + hours + " MM:0" + mins + " SS:0" + seconds);
            } else if(hours<10 && minutes >10) {
                System.out.println("HH:0" + hours + " MM:" + mins + " SS:" + seconds);
            } else if(hours>10 && minutes >10) {
                System.out.println("HH:" + hours + " MM:" + mins + " SS: " + seconds);
            } else if(hours>10 && minutes <10) {
                System.out.println("HH:" + hours + " MM:0" + mins + " SS:0" + seconds);
            }
        }
    }

    public static void getDurationString(int second) {
        if(second<0) {
            System.out.println("Invalid Value");
        }
        else {
            int minutes = second/60;
            second=second%60;
            getDurationString(minutes,second);
        }
    }

}


