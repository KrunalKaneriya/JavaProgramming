public class Main {

    public static void main(String[] args) {

        CountDown countDown = new CountDown();

        CountDownThread t1 = new CountDownThread(countDown);
        t1.setName("Thread 1");

        CountDownThread t2 = new CountDownThread(countDown);
        t2.setName("Thread 2");

        t1.start();
        t2.start();
    }
}

class CountDown{
    // int i; // This variable is class instance variable so it will be stored in heap not on thread stack
    public void doCountDown() {
        for(int i=10;i>0;i--) { //If we create a new variable here then it will be created in thread stack
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }

}

class CountDownThread extends Thread{
    private CountDown countDownObject;
    public CountDownThread(CountDown countDown) {
        this.countDownObject = countDown;
    }

    public void run() {
        countDownObject.doCountDown();
    }



}