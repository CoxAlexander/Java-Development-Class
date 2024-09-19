//Last edit: 9/18/2024
//TestFiles.java
//Alexander Cox
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
//import java.nio.file.ReadOnlyFileSystemException;
import java.util.Scanner;
import java.util.ArrayList;
public class TestFiles {
    public static void main(String[] args) {
        String currentTask;         //Task the file is on atm
        boolean completed;          //Will be if the task is completed
        String newLine = "\n";      //To make the tasks on different lines
        ArrayList<String> taskList = new ArrayList<String>();   //Arraylist creation
        String fileName = "Final Project\\Test.txt"; //file that it is being wrote to
        Scanner keyboard = new Scanner(System.in);      //scanner for testing purposes
        Tasks firstTasks = new Tasks();                 
        taskList.addAll(ReadFile(fileName));            //set the arraylist to add every thing that was in the list already
        System.out.print(taskList);                     //testing print    
        System.out.println("Enter a task you want to do");
        currentTask = keyboard.nextLine();
        currentTask = currentTask + newLine;            //add \n to make it go to the next line
        firstTasks.setTask(currentTask);                //set to the task object

        try {
          FileWriter myWriter = new FileWriter(fileName, true); //write to the file with append set to true
          myWriter.write(currentTask);                                  //write the current task to the file
          myWriter.close();
          System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }
    }
    public static ArrayList ReadFile(String fileTitle){ //Read the current tasks already saved to the file
        ArrayList<String> tasks = new ArrayList<String>(); // Create a arrarylist
        try {
        File myObj = new File(fileTitle);       //get to the file
        Scanner myReader = new Scanner(myObj);  //scan the file
        while (myReader.hasNextLine()) {        //read every line of the file
            String data = myReader.nextLine();  //get the current line of data
            tasks.add(data);                    //add a new string to the arraylist
            
        }
        } catch (IOException e) {               //catch an exception
            System.out.println("An error occurred.");
            e.printStackTrace();
            
        }
        return tasks;                           //return the arrarylist
    }
}