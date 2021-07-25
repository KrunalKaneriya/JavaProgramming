import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class App {

  public static void main(String[] args) throws Exception {
    try (
      FileOutputStream binFile = new FileOutputStream("data.dat"); //Creates file outputstream for writing the file
      FileChannel binChannel = binFile.getChannel()
    ) {
      ByteBuffer buffer = ByteBuffer.allocate(100);
      byte[] byteArray = "Hello World!".getBytes(); //Now java.Nio works with bytes so we need to create a byte array and get the bytes
      byte[] byteArray2 = "Nice To Meet You!".getBytes();

      buffer.put(byteArray);
      long int1Pos = byteArray.length; // Length of String
      buffer.putInt(245);
      long int2Pos = int1Pos + Integer.BYTES; //Length of String + 4
      buffer.putInt(-98765);

      buffer.put(byteArray2);
      long int3Pos = int2Pos + Integer.BYTES + byteArray2.length; // Length of String + 4 + Length of String2
      buffer.putInt(1000);
      buffer.flip();

      binChannel.write(buffer);
      buffer.flip();

      RandomAccessFile ra = new RandomAccessFile("data.dat", "r");
      FileChannel channel = ra.getChannel();

    //   //Reading the Integers From File in Reverse Order
      ByteBuffer readBuffer = ByteBuffer.allocate(Integer.BYTES);

      //Reading the last int from channel
      channel.position(int3Pos);
      channel.read(readBuffer);
      readBuffer.flip();
      System.out.println(
        "Reading the Last Integer Saved In File: " + readBuffer.getInt(0)
      ); // we are using relative reading
      // readBuffer.flip();
      //Reading the Middle Int
      channel.position(int2Pos);
      channel.read(readBuffer);
      readBuffer.flip();
      System.out.println(
        "Reading the Middle Integer Saved in File: " + readBuffer.getInt(0)
      );
      // readBuffer.flip();

      //Reading the First Int
      channel.position(int1Pos);
      channel.read(readBuffer);
      readBuffer.flip();
      System.out.println(
        "Reading the First Integer Saved in File: " + readBuffer.getInt(0)
      );

      RandomAccessFile copyFile = new RandomAccessFile("data_copy.dat","rw");
      FileChannel copyChannel  = copyFile.getChannel();
      channel.position(0);
    //   long numTransferred = copyChannel.transferFrom(channel, 0, channel.size());
    long numTransferred = channel.transferTo(0, channel.size(), copyChannel);
      System.out.println("Num Transferred = " + numTransferred);

      channel.close();
      ra.close();
      copyChannel.close();


    //   readBuffer.flip();


      //We are Reading the Integer First and After that the two String from file And Using Locations

    //   byte[] outputString = "Hello World!".getBytes();
    //   long str1Pos = 0; //Starting pos of outputString
    //   long newIntPos1 = outputString.length; //Starting pos of first int
    //   long newIntPos2 = newIntPos1 + Integer.BYTES; //Starting pos of second int
    //   byte[] outputString2 = "Nice To Meet You".getBytes();
    //   long str2Pos = newIntPos2 + Integer.BYTES; //Starting pos of second String
    //   long newIntPos3 = str2Pos + outputString2.length; //Starting pos of third Int

    //   ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
    //   intBuffer.putInt(245);
    //   intBuffer.flip();
    //   binChannel.position(newIntPos1);
    //   binChannel.write(intBuffer);

    //   intBuffer.flip();
    //   intBuffer.putInt(-98765);
    //   intBuffer.flip();
    //   binChannel.position(newIntPos2);
    //   binChannel.write(intBuffer);

    //   intBuffer.flip();
    //   intBuffer.putInt(1000);
    //   intBuffer.flip();
    //   binChannel.position(newIntPos3);
    //   binChannel.write(intBuffer);

    //   binChannel.position(str1Pos);
    //   binChannel.write(ByteBuffer.wrap(outputString));

    //   binChannel.position(str2Pos);
    //   binChannel.write(ByteBuffer.wrap(outputString2));
    //   intBuffer.flip();

    //   ra.close();
    }
  }
}
