import java.io.*;
import java.nio.file.*;
public class ReadFile
{
   public static void main(String[] args)
   {
      Path file =  Paths.get("Chapter 11 (you do it)\\Grades.txt");
      InputStream input = null;
      try
      {
         input = Files.newInputStream(file);
         BufferedReader reader = new BufferedReader(new InputStreamReader(input));
         String s = null;
         s = reader.readLine();
         System.out.println(s);
         input.close();
       }
       catch (IOException e)
       {
          System.out.println(e);
       }
   }
}