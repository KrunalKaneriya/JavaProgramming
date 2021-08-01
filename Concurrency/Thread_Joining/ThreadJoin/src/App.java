public class App {
    public static void main(String[] args) throws Exception {
        Thread runnable = new Thread(new MyRunnable());

        Thread anonymousThread = new Thread(new MyRunnable() {
            public void run() {
                System.out.println("Now The Thread is in Anonymous Class");
                try{
                runnable.join();
                System.out.println("AnonyMous Class Work Completed Successfully And The Runnable Thread is Completed");
                } catch(InterruptedException e) {
                    System.out.println("AnonyMous Class Interrupted");
                }

            }
        });
        runnable.setName("Runnable Thread");
        
        runnable.start();
        anonymousThread.start();
        
        
        
        

    }

}