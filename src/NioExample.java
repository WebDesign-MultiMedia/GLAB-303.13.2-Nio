//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.io.*;
import java.nio.ByteBuffer;
import  java.nio.channels.FileChannel;

public class NioExample {
    public static void main(String[] args) throws IOException
    {

        // initializing two files in Array;
        String[] inputFiles = {"C:/Users/julio.salas/Downloads/file1.txt", "C:/Users/julio.salas/Downloads/file2.txt"};


        // specify out file with path location
        // files contents will be written in these files
        String outputFile = "C:/Users/julio.salas/Downloads/nioOutput.txt";

        // GEt channel for destination or outputFile
        FileOutputStream fos = new FileOutputStream(outputFile);
        FileChannel targetChannel = fos.getChannel();

        for (int i = 0; i < inputFiles.length; i++) {

            // Get channel for inputFiles
            FileInputStream fis = new FileInputStream(inputFiles[i]);
            FileChannel inputchannel = fis.getChannel();
            long size = inputchannel.size();
            ByteBuffer buf = ByteBuffer.allocate((int)size);
            System.out.print((char) buf.get());
            while (inputchannel.read(buf)> 0) {
                buf.flip();
                while (buf.hasRemaining()) {
                    System.out.print((char) buf.get());
                    targetChannel. write(buf);
                }
            }
       // fis.close();
        }
    }}