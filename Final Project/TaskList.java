//Last edit: 10/5/2024
//TaskList.java
//Alexander Cox
//Error: throws error if something is in txt file that isnt suppoed to 

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;

public class TaskList extends JFrame implements ItemListener{
    public TaskList(ArrayList<Tasks> tasks) {
        
        int counter = 0;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        
        
        for(counter = 0; counter < tasks.size(); ++counter){
            JCheckBox TaskBox = new JCheckBox(tasks.get(counter).getTask(), tasks.get(counter).getCompleted());
            add(TaskBox);
        }
        
        
    }
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        String fileName = "Final Project\\Task.txt";
        int counter = 0;
        String chore;
        final int WIDTH = 300;
        final int HEIGHT = 200;
        Boolean compBool;
        ArrayList<Tasks> taskList = new ArrayList<>();
        ArrayList<Boolean> completionList = new ArrayList<>();
        ArrayList<String> tasks = new ArrayList<>();
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
        TaskList aFrame = new TaskList(taskList);
        aFrame.setSize(WIDTH,HEIGHT);
        aFrame.setVisible(true);
        
    }
    @SuppressWarnings("rawtypes")
    public static ArrayList ReadFileTask(String fileTitle){ //Read the current tasks already saved to the file
        ArrayList<String> tasks = new ArrayList<>(); // Create a arrarylist
        
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
            
        }
        return tasks;                           //return the arrarylist
    }
    @SuppressWarnings("rawtypes")
    public static ArrayList ReadFileComp(String fileTitle){
        ArrayList<String> completionNum = new ArrayList<>();
        ArrayList<Boolean> completionBol = new ArrayList<>();
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
                
            } 
            
            return completionBol;          
    }   
    public void DisplayTasks(ArrayList<Tasks> tasks)  {
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

    @Override
    public void itemStateChanged(ItemEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}