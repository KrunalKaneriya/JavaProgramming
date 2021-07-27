public class AnotherThread extends Thread{
    @Override
    public void run() {
        System.out.println("Hello from " + currentThread().getName());

        try {
            Thread.sleep(3000);;
        } catch (InterruptedException e) {
            System.out.println("Another thread woke me up");
        }

        System.out.println("Three Seconds Are Passed and Now I'm Alive");
    }
}
