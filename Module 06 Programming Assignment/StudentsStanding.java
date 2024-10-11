import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.*;
import static java.nio.file.StandardOpenOption.*;
import java.text.*;
import java.util.Scanner;
public class StudentsStanding{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Path inGoodSandingFile = Paths.get(".\\Module 06 Programming assignment\\inGoodStandingFile.txt");
        Path inBadSandingFile = Paths.get(".\\Module 06 Programming assignment\\inBadStandingFile.txt");
        final String STUDENT_ID_FORMAT = "0000";
        final int STUDENT_ID_LENGTH = STUDENT_ID_FORMAT.length();
        final String NAME_FORMAT = "        ";
        final int NAME_LENGTH = NAME_FORMAT.length();
        final double PASSING_GRADE = 2.0;
        final String GPA_FORMAT = "0.00";
        String delimiter = ",";
        String s = STUDENT_ID_FORMAT + delimiter + NAME_FORMAT + delimiter + NAME_FORMAT + delimiter + GPA_FORMAT;
        System.getProperty("line.separator");
        final int RECSIZE = s.length();
        FileChannel fcIn = null;
        FileChannel fcOut = null;
        String idString;
        String lastName = "";
        String firstName = "";
        int id;
        double GPA;
        final String QUIT = "999";
        createEmptyFile(inGoodSandingFile, s);
        createEmptyFile(inBadSandingFile,s);
        try{
            fcIn = (FileChannel)Files.newByteChannel(inGoodSandingFile, CREATE, WRITE);
            fcOut = (FileChannel)Files.newByteChannel(inBadSandingFile, CREATE, WRITE);
            System.out.println("Enter Student ID: ");
            while (true) { 
                idString = input.nextLine();
                if((idString.length() == STUDENT_ID_LENGTH) && (!(idString.matches("[a-zA-Z] + ")))){
                    break;
                }   
                else{
                    System.out.printf("Invalid student ID Number. It needs to be %d digits long: ", STUDENT_ID_LENGTH);
                }
            }
            while(!(idString.equals(QUIT))){
                id = Integer.parseInt(idString);
                for(int i = 0; i<2; ++i){
                    String name;
                    System.out.printf("Enter the student's $s name:",(i == 0)?"last" : "first");
                    name = input.nextLine();
                    int entryLength = name.length();
                    int missingSpaces = (NAME_LENGTH - entryLength);
                    StringBuilder sb = new StringBuilder(name);
                    if(entryLength>NAME_LENGTH){
                        sb.setLength(NAME_LENGTH);
                    }
                    else {
                        sb.append(" ".repeat(missingSpaces));
                    }
                    switch(i){
                        case 0 -> {
                            lastName = sb.toString();
                            break;
                        }
                        case 1 -> {
                            firstName = sb.toString();
                            break;
                        }
                    }
                }
                System.out.println("Enter GPA: ");
                GPA = input.nextDouble();
                input.nextLine();
                DecimalFormat df = new DecimalFormat(GPA_FORMAT);
                s = idString + delimiter + lastName + delimiter + firstName + delimiter + df.format(GPA) + System.getProperty("Line.separator");
                byte data[] = s.getBytes();
                ByteBuffer  buffer = ByteBuffer.wrap(data);
                if (GPA >= PASSING_GRADE){
                    fcIn.position(id * RECSIZE);
                    fcIn.write(buffer);
                }
                else{
                    fcOut.position(id *RECSIZE);
                    fcOut.write(buffer);
                }
                System.out.print("Enter a next student ID # or " + QUIT + " to quit: ");
                while (true) { 
                    idString = input.nextLine();
                    if((idString.length() == STUDENT_ID_LENGTH || idString.length() == QUIT.length()) && (!(idString.matches("[a-zA-Z] + ")))){
                        break;
                    }   
                    else{
                        System.out.printf("Invalid student ID Number. It needs to be %d digits long: ", STUDENT_ID_LENGTH);
                    }
                }
            }
            fcIn.close();
            fcOut.close();
        }
        catch(Exception e){
            System.out.println("error message: " + e);
        }   
    }
    public static void createEmptyFile(Path file, String s){
        final int NUMRECS = 10000;
        try {
            OutputStream outStr = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outStr));
            for(int count = 0; count<NUMRECS; ++count){
                writer.write(s,0,s.length());
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("error message: " + e);
        }
    }
}