//9/14/2024
//TestFiles.java
//Alexander Cox

import java.io.FileWriter;
import java.io.IOException;

public class TestFiles {
    public static void main (String args[]){
        String append = "\n";
        String test = "ahh3";
        String text = test + append;
        try {
            FileWriter fWriter = new FileWriter("Final Project/Test.txt", true);
            fWriter.write(text);
            System.out.println(text);
            fWriter.close();
        }
        catch(IOException e){
            System.out.print(e.getMessage());
        }

    }
}