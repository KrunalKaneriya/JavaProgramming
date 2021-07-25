import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Random;

public class App {

  public static void main(String[] args) throws Exception {
    try (
      FileOutputStream binFile = new FileOutputStream("data.dat"); //Creates file outputstream for writing the file
      FileChannel binChannel = binFile.getChannel()
    ) {
        ByteBuffer buffer = ByteBuffer.allocate(100);
      byte[] byteArray = "Hello World!".getBytes(); //Now java.Nio works with bytes so we need to create a byte array and get the bytes
      byte[] byteArray2 = "Nice To Meet You!".getBytes();
      //Chaining put methods together

      // buffer.put(byteArray).putInt(245).putInt(-98765).put(byteArray2).putInt(1000);

      buffer.put(byteArray);
      long int1Pos = byteArray.length; // Length of String
      buffer.putInt(245);
      long int2Pos = int1Pos + Integer.BYTES; //Length of String + 4
      buffer.putInt(-98765);
      
      buffer.put(byteArray2);
      long int3Pos = int2Pos + Integer.BYTES + byteArray2.length;// Length of String + 4 + Length of String2
      buffer.putInt(1000);
      buffer.flip();

      binChannel.write(buffer);


      RandomAccessFile ra = new RandomAccessFile("data.dat","r");
      FileChannel channel = ra.getChannel();

      //Reading the Integers From File in Reverse Order
      ByteBuffer readBuffer = ByteBuffer.allocate(Integer.BYTES);

      //Reading the last int from channel
      channel.position(int3Pos);
      channel.read(readBuffer);
      readBuffer.flip();
      System.out.println("Reading the Last Integer Saved In File: " + readBuffer.getInt(0)); // we are using relative reading
      // readBuffer.flip();
      //Reading the Middle Int
      channel.position(int2Pos);
      channel.read(readBuffer);
      readBuffer.flip();
      System.out.println("Reading the Middle Integer Saved in File: " + readBuffer.getInt(0));
      // readBuffer.flip();

      //Reading the First Int
      channel.position(int1Pos);
      channel.read(readBuffer);
      readBuffer.flip();
      System.out.println("Reading the First Integer Saved in File: " + readBuffer.getInt(0));
      // readBuffer.flip();



      //Reading the contents from file via byteBuffer
      // ByteBuffer readBuffer = ByteBuffer.allocate(100);
      // channel.read(readBuffer);
      // readBuffer.flip();
      // byte[] inputString = new byte[byteArray.length];
      // readBuffer.get(inputString);
      // System.out.println("InputString = " + new String(inputString));
      // System.out.println("Int1 = " + readBuffer.getInt());
      // System.out.println("Int2 = " + readBuffer.getInt());
      // byte[] inputString2 = new byte[byteArray2.length];
      // readBuffer.get(inputString2);
      // System.out.println("InputString2 = " + new String(inputString2));



























      // ByteBuffer buffer = ByteBuffer.wrap(byteArray); //And after that create a buffer of byteArray which will be backed by buffer.
      // ByteBuffer buffer = ByteBuffer.allocate(byteArray.length);
      // buffer.put(byteArray);
      // buffer.flip();
      // int numBytes = binChannel.write(buffer); //Writing the buffer contents which is byteArray to file via channel and printing the number of Bytes writter.
      // System.out.println("numBytes was Written: " + numBytes);

      // ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
      // intBuffer.putInt(245); // Putting the int in buffer
      // intBuffer.flip(); //Calling the flip method to reset the position to zero
      // int intBytes = binChannel.write(intBuffer); // writing the buffer contents from zero index
      // System.out.println("intBytes was Written: " + intBytes);

      // intBuffer.flip();
      // intBuffer.putInt(-98574);
      // intBuffer.flip();
      // int intBytes2 = binChannel.write(intBuffer);
      // System.out.println("intBytes2 was written: " + intBytes2);

      // RandomAccessFile ra = new RandomAccessFile("data.dat", "r");
      // FileChannel channel = ra.getChannel();
      // byteArray[0] = 'a';
      // byteArray[1] = 'b';
      // buffer.flip(); //must be called to set the buffer position to 0 else it will read the byte[] not buffer
      // long size = channel.read(buffer);
      // System.out.println("The number of size read is " + size);
      // if(buffer.hasArray()) {
      //     System.out.println("byte Buffer "  + new String(buffer.array()) + " and the channel is at position "+  channel.position());
      // }

      // //Absolute Read
      // intBuffer.flip();
      // channel.read(intBuffer);
      // System.out.println("Reading the Integer " + intBuffer.getInt(0) + " at channel position " + channel.position());
      // intBuffer.flip();
      // channel.read(intBuffer);
      // intBuffer.flip(); //Adding another flip to check if absolute position is changed?
      // System.out.println("Reading the Integer " + intBuffer.getInt(0) + " at channel position " + channel.position());
      // System.out.println("Reading the Integer " + intBuffer.getInt() + " at channel position " + channel.position());

      /*Relative Read*/
      //Now reading the integers stored in file
      // intBuffer.flip(); //resetting the int position to 0
      // long numBytesRead = channel.read(intBuffer); //Using channel to read the integer
      // intBuffer.flip();
      // System.out.println("Printing the Number: " + intBuffer.getInt() + " and the channel is at position "+  channel.position());
      // intBuffer.flip();
      // numBytesRead = channel.read(intBuffer);
      // intBuffer.flip();
      // System.out.println("Printing the Number " + intBuffer.getInt() + " and the channel is at position "+  channel.position());
      // long numBytesRead = channel.read(buffer); //reading from the file via channel and passing the buffer as to save the contents
      // System.out.println("outputBytes = " + new String(byteArray));
      /* **************************************** */

      //Creating new RandomAccessFile object to read the data.dat file
      // RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
      // //Creating the new Byte array to get the string and the length is the length of byteArray which contains hello world string
      // byte[] b= new byte[byteArray.length];
      // ra.read(b); //reading the contents and putting it into byte array b
      // System.out.println(new String(b)); //Creating new String based on byte array b

      // //Reading two last ints from ra object
      // long int1 = ra.readInt();
      // long int2 = ra.readInt();

      // System.out.println(int1);
      // System.out.println(int2);
      ra.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
