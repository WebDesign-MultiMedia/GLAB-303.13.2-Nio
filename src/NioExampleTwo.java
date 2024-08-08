import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

public class NioExampleTwo {
    public  static  void main(String[] args) throws IOException{
        // Input Files
        String[] inputFiles = {"C:/Users/julio.salas/Downloads/file1.txt", "C:/Users/julio.salas/Downloads/file2.txt"};
        String outputFile = "C:/Users/julio.salas/Downloads/nioOutput.txt";

        FileOutputStream fos = new FileOutputStream(outputFile);
        WritableByteChannel targetChannel = fos.getChannel();

        for (int i = 0; i < inputFiles.length; i++)
        {
            FileInputStream fis = new FileInputStream(inputFiles[i]);
            FileChannel inputChannel = fis.getChannel();

            inputChannel.transferTo(0, inputChannel.size(), targetChannel);

            inputChannel.close();
            fis.close();
        }
        targetChannel.close();
        fos.close();
        System.out.println("Completed");
    }
}
