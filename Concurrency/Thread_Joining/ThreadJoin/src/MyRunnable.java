public class MyRunnable implements Runnable{
    public void run() {
        System.out.println("*******************\nNow Running the Runnable interface Thread");
        System.out.println("The Thread Name is "  + Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
            System.out.println("My Runnable Thread is Woken Now With Good Sleep");
        } catch (InterruptedException e) {
            System.out.println("Thread Did not Have Good Sleep\n**************************");
        }
    }

}
