public class Main {

    public static void main(String[] args) {
        System.out.println("Hello from the main thread");

        Thread anotherThread = new AnotherThread();
        anotherThread.setName("==Another Thread==");
        anotherThread.start();

        new Thread() {
            public void run() {
                System.out.println("Hello from anonymous class thread..");
            }
        }.start();


        Thread myAnonyMousRunnable = new Thread(new MyRunnable() {
            @Override
            public void run() {
                System.out.println("Hello from anonymous class of runnable interface");
            }
        });
        myAnonyMousRunnable.start();


        Thread myRunnable = new Thread(new MyRunnable());
        myRunnable.start();

        System.out.println("Hello again from main thread");
    }
}
