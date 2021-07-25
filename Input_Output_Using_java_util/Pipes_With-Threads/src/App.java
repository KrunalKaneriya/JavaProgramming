import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;
import java.sql.Date;
import java.util.Calendar;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            // Pipe pipe =  Pipe.open();

            // Runnable writer = new Runnable(){
            //     @Override
            //     public void run() {
            //         try {
            //             Pipe.SinkChannel sinkChannel = pipe.sink();
            //             ByteBuffer buffer = ByteBuffer.allocate(56);

            //             for(int i=0;i<10;i++) {
            //                 String currentTime = "The Current Time is: " + System.currentTimeMillis();

            //                 buffer.put(currentTime.getBytes());
            //                 buffer.flip();

            //                 while(buffer.hasRemaining()) {
            //                     sinkChannel.write(buffer);
                            
            //                 }
            //                 buffer.flip();
            //                 Thread.sleep(100);
            //             }
            //         } catch(Exception e) {e.printStackTrace();}
            //     }
            // };

            // Runnable reader = new Runnable() {
            //     @Override
            //     public void run() {

            //         try {
            //             Pipe.SourceChannel sourceChannel  = pipe.source();
            //             ByteBuffer buffer = ByteBuffer.allocate(56);

            //             for(int i=0;i<10;i++) {
            //                 int bytesRead = sourceChannel.read(buffer); //This line reads the given bytes to the buffer and it returns the number of bytes read
            //                 byte[] timeString = new byte[bytesRead];
            //                 buffer.flip();
            //                 buffer.get(timeString);
            //                 System.out.println("Reader Thread: " + new String(timeString));
            //                 buffer.flip();
            //                 Thread.sleep(100);
                        
            //             }

            //         } catch(Exception e) {
            //             e.printStackTrace();
            //         }
            //     }
            // };

            Pipe pipe = Pipe.open();

            Runnable writer = new Runnable(){
                @Override
                public void run() {


                    try {
                        Pipe.SinkChannel sinkChannel = pipe.sink();
                        ByteBuffer buffer = ByteBuffer.allocate(60);

                        for(int i=0;i<10;i++) {
                            String currentTime = "The Current Time is: " + Calendar.HOUR + " : " + Calendar.MINUTE + " : " + Calendar.SECOND + " : " + Calendar.MILLISECOND;
                            buffer.put(currentTime.getBytes());
                            buffer.flip();

                            while(buffer.hasRemaining()) {
                                sinkChannel.write(buffer);
                            }
                            
                            buffer.flip();
                            Thread.sleep(100);
                        }
                    } catch(Exception e) {
                        e.printStackTrace();
                    }
                }
            };

            Runnable reader = new Runnable() {
                @Override 
                public void run() {

                    try{
                    Pipe.SourceChannel sourceChannel = pipe.source();
                    ByteBuffer buffer = ByteBuffer.allocate(60);

                    for(int i=0;i<10;i++) {
                        int bytesRead = sourceChannel.read(buffer); //This function is reading the bytes from thread and putting them
                        //buffer and it returns the number of bytes read
                        byte[] currentTime = new byte[bytesRead];
                        buffer.flip();
                        buffer.get(currentTime);
                        System.out.println("The Current Time Readed From Thread is: " + new String(currentTime));
                        buffer.flip();
                        Thread.sleep(100);
                    }
                    } catch(Exception e) {
                        e.printStackTrace();
                    }
                }
            };

            new Thread(writer).start();
            new Thread(reader).start();


        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
