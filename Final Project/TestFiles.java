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
        boolean completed = false;          //Will be if the task is completed
        String completedStr;
        String comma = ",";
        int x;
        String newLine = "\n";      //To make the tasks on different lines
        ArrayList<String> taskList = new ArrayList<String>();   //Arraylist creation
        String fileName = "Final Project\\Test.txt"; //file that it is being wrote to
        Scanner keyboard = new Scanner(System.in);      //scanner for testing purposes
        Tasks firstTasks = new Tasks();                 
        taskList.addAll(ReadFile(fileName));            //set the arraylist to add every thing that was in the list already
        System.out.print(taskList);                     //testing print    
        System.out.print("Enter a task you want to do:");
        currentTask = keyboard.nextLine();
        currentTask = currentTask + comma;
        System.out.print("Is the task completed 1 for no, 0 for yes:");
        x = keyboard.nextInt();
        if(x==1) {
            completed = false;
            completedStr = "1";
        }else{
            completed = true;
            completedStr = "2";
        }
        firstTasks.setCompleted(completed);
        firstTasks.setTask(currentTask);                //set to the task object

        try {
          FileWriter myWriter = new FileWriter(fileName, true); //write to the file with append set to true
          myWriter.write(currentTask);                                  //write the current task to the file
          myWriter.write(completedStr);
          myWriter.write(newLine);
          myWriter.close();
          System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }
    }
    public static boolean isCompleted(int num1){
        int completetion = num1;
        boolean completed;

        if (completetion == 1){
            completed = true;
        }
        else
            completed = false;
        return completed;
    }
    public static ArrayList ReadFile(String fileTitle){ //Read the current tasks already saved to the file
        ArrayList<String> tasks = new ArrayList<String>(); // Create a arrarylist
        String [] tempArrary;
        try {
        File myObj = new File(fileTitle);       //get to the file
        Scanner myReader = new Scanner(myObj);  //scan the file
        while (myReader.hasNextLine()) {        //read every line of the file
            String data = myReader.nextLine();  //get the current line of data
            tempArrary = data.split(",");
            tasks.add(tempArrary[0]);                    //add a new string to the arraylist
            
        }
        } catch (IOException e) {               //catch an exception
            System.out.println("An error occurred.");
            e.printStackTrace();
        
        }
        return tasks;                           //return the arrarylist
    }
    
}