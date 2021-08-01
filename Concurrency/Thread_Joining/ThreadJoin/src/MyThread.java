public class MyThread extends Thread{

    private CountDown countDown;

    public MyThread (CountDown countDown) {
        this.countDown = countDown;
    }

    public void run() {
        countDown.doCountDown();
    }
    
}
