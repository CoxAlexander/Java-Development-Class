//Last edit: 10/5/2024
//TaskList.java
//Alexander Cox
//Error: throws error if something is in txt file that isnt suppoed to 

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;
import java.lang.StringBuilder;
public class TaskList{
    public static void main(String[] args) {
        String fileName = "Final Project\\Task.txt";
        int counter = 0;
        String chore;
        Boolean compBool;
        ArrayList<Tasks> taskList = new ArrayList<Tasks>();
        ArrayList<Boolean> completionList = new ArrayList<Boolean>();
        ArrayList<String> tasks = new ArrayList<String>();
        tasks.addAll(ReadFileTask(fileName));
        completionList.addAll(ReadFileComp(fileName));
        for(counter = 0; counter<tasks.size(); ++counter){
            compBool = completionList.get(counter);
            chore = tasks.get(counter);
            taskList.add(new Tasks(chore, compBool));
        }
        for(counter = 0; counter<taskList.size(); ++counter){
            System.out.println(taskList.get(counter).getCompleted() + " " + taskList.get(counter).getTask());
        }
       
        DisplayTasks(taskList);
    }
    public static ArrayList ReadFileTask(String fileTitle){ //Read the current tasks already saved to the file
        ArrayList<String> tasks = new ArrayList<String>(); // Create a arrarylist
        
        String [] tempArray;
        try {
        File myObj = new File(fileTitle);       //get to the file
        Scanner myReader = new Scanner(myObj);  //scan the file
        while (myReader.hasNextLine()) {        //read every line of the file
            String data = myReader.nextLine();  //get the current line of data
            tempArray = data.split(",", 2);
            tasks.add(tempArray[0]);                    //add a new string to the arraylist
        }
        } catch (IOException e) {               //catch an exception
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return tasks;                           //return the arrarylist
    }
    public static ArrayList ReadFileComp(String fileTitle){
        ArrayList<String> completionNum = new ArrayList<String>();
        ArrayList<Boolean> completionBol = new ArrayList<Boolean>();
        String [] tempArrary;
        int x;
        try {
            File myObj = new File(fileTitle);       //get to the file
            Scanner myReader = new Scanner(myObj);  //scan the file
            x=0;
            while (myReader.hasNextLine()) {        //read every line of the file
                String data = myReader.nextLine();  //get the current line of data
                if(!data.isBlank() && !(data.substring(0, 1).equals("\\")) && !(data.substring(0, 1).equals(" "))){
                    tempArrary = data.split(",", 2);
                    if (tempArrary.length == 2){
                        
                        completionNum.add(tempArrary[1]);  
                    }
                } 
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
    public static void DisplayTasks(ArrayList<Tasks> tasks) {
        int counter = 0;
        StringBuilder sb = new StringBuilder();
        for(counter = 0; counter < tasks.size(); ++counter){
            sb.append(tasks.get(counter).getTask());
            if (tasks.get(counter).getCompleted()) {
                sb.append(" Completed");
            }
            else{
                sb.append(" To do");
            }
            sb.append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }
    /*public static void WriteFile(ArrayList<Tasks> tasks){
        String compString;
        String newLine = "\n";
        String fileName = "Final Project\\Task.txt";
        FileWriter myWriter = new FileWriter(fileName, false);
    } 
        //code from testFiles.java
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
    */
}