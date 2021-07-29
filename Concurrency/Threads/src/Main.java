public class Main {

    public static void main(String[] args) {
        Thread anotherThread = new AnotherThread();
        anotherThread.setName("Another Thread");
        anotherThread.start();

//        runnableThread.start();
//        anotherThread.interrupt();
//        System.out.println("Hello from the main thread");
//
//        Thread anotherThread = new AnotherThread();
//        anotherThread.setName("==Another Thread==");
//        anotherThread.start();
//
//        new Thread() {
//            public void run() {
//                System.out.println("Hello from anonymous class thread..");
//            }
//        }.start();
//
//
        Thread myAnonyMousRunnable = new Thread(new MyRunnable() {
            @Override
            public void run() {
                System.out.println("Hello from anonymous class of runnable interface");
                try{
                    anotherThread.join(500);
                    System.out.println("Another thread work Completed. I'm running again..");
                } catch(InterruptedException e) {
                    System.out.println("I couldn't wait after all. I was interrupted");
                }
            }

        });
        myAnonyMousRunnable.start();
//
//
//        Thread myRunnable = new Thread(new MyRunnable());
//        myRunnable.start();
////        anotherThread.interrupt();
//
//        System.out.println("Hello again from main thread");
    }
}
