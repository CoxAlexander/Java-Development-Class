//Last edit: 9/18/2024
//TestFiles.java
//Alexander Cox
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
public class TestFiles {
    public static void main(String[] args) {
        String currentTask;         //Task the file is on atm
        boolean completed = false;          //Will be if the task is completed
        String completedStr;
        String comma = ",";
        
        int x;
        String newLine = "\n";      //To make the tasks on different lines
        ArrayList<String> taskList = new ArrayList<String>();   //Arraylist creation
        ArrayList<Boolean> completionList = new ArrayList<Boolean>();
        String fileName = "Final Project\\Test.txt"; //file that it is being wrote to
        Scanner keyboard = new Scanner(System.in);      //scanner for testing purposes
        Tasks firstTasks = new Tasks();                 
        taskList.addAll(ReadFileTask(fileName));            //set the arraylist to add every thing that was in the list already
        completionList.addAll(ReadFileComp(fileName));
        System.out.print(taskList);                     //testing print    
        System.out.print("Enter a task you want to do:");
        currentTask = keyboard.nextLine();
        currentTask = currentTask + comma;
        System.out.print("Is the task completed 0 for no, 1 for yes:");
        x = keyboard.nextInt();
        if(x==0) {
            completed = false;
            completedStr = "0";
        }else{
            completed = true;
            completedStr = "1";
        }
        firstTasks.setCompleted(completed);
        firstTasks.setTask(currentTask);                //set to the task object
        taskList.add(firstTasks.getTask() + firstTasks.getCompleted());

        try {
          FileWriter myWriter = new FileWriter(fileName, true); //write to the file with append set to true
            myWriter.write(currentTask);                                  //write the current task to the file
            myWriter.write(completedStr);
            myWriter.write(newLine);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
            String[] tasks = new String[taskList.size()];
            for (int y=0 ;y <taskList.size(); ++y){
                tasks[y] = taskList.get(y);

            }

            DisplayTasks(tasks);
        } catch (IOException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }
        
    }
    public static ArrayList ReadFileTask(String fileTitle){ //Read the current tasks already saved to the file
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
    public static void DisplayTasks(String[] tasks) {
        JOptionPane.showMessageDialog(null, tasks);
    }
    public static ArrayList ReadFileComp(String fileTitle){
        ArrayList<String> completionNum = new ArrayList<String>();
        ArrayList<Boolean> completionBol = new ArrayList<Boolean>();
        String [] tempArrary;
        int x;
        try {
            File myObj = new File(fileTitle);       //get to the file
            Scanner myReader = new Scanner(myObj);  //scan the file
            while (myReader.hasNextLine()) {        //read every line of the file
                String data = myReader.nextLine();  //get the current line of data
                tempArrary = data.split(",");
                completionNum.add(tempArrary[1]);                    //add a new string to the arraylist
            }
            for (x=0;x<completionNum.size(); ++x){
                if(completionNum.get(x).equals("0")) {
                    completionBol.add(false);
                }else{
                    completionBol.add(true);
                }
            }
            } catch (IOException e) {               //catch an exception
                System.out.println("An error occurred.");
                e.printStackTrace();
            
            }
            return completionBol;          
    }

    
}