//Last edit: 10/11/2024
//TaskList.java
//Alexander Cox
//Error: throws error if something is in txt file that isnt suppoed to 
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;


public class TaskList{
    public static void mainList(ArrayList<Tasks> tasks) {
        ArrayList<JCheckBox> checkList = new ArrayList<>();
        JFrame aFrame = new JFrame();
        int counter = 0;
        final int WIDTH = 300;
        int HEIGHT = 100;
        aFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aFrame.setLayout(null);
        JButton addTaskButton = new JButton("Add a Task");
        for(counter = 0; counter < tasks.size(); ++counter){
            int y = counter*35;
            checkList.add(new JCheckBox(tasks.get(counter).getTask(), tasks.get(counter).getCompleted()));
            checkList.get(counter).setBounds(50,y,1000, 25);
            aFrame.add(checkList.get(counter));
            checkList.add(checkList.get(counter));
            checkList.get(counter).addActionListener(e -> checkBoxes(tasks, checkList));
        }
        addTaskButton.setBounds(50,(tasks.size()*35), 200, 25);
        HEIGHT = (tasks.size()+1)*50;
        aFrame.add(addTaskButton);
        aFrame.setSize(WIDTH,HEIGHT);
        aFrame.setVisible(true);
        addTaskButton.addActionListener(e -> {aFrame.dispose(); addTask(tasks);});
        } 
    public static void checkBoxes(ArrayList <Tasks>tasks,ArrayList<JCheckBox> checkList){
        for (int counter = 0; counter<tasks.size(); ++counter){
            String currentTask = tasks.get(counter).getTask();
            Boolean oldCompletetion = tasks.get(counter).getCompleted();
            if(oldCompletetion == checkList.get(counter).isSelected()){
                tasks.set(counter, new Tasks(currentTask, checkList.get(counter).isSelected()));
            }
        }
        writeFile(tasks);
    } 
    public static void addTask(ArrayList<Tasks> tasks){
        final int WIDTH = 300;
        final int HEIGHT = 300;
        JFrame addFrame = new JFrame();
        JLabel taskJLabel = new JLabel("Enter a new task");
        taskJLabel.setBounds(50,50,200,50);
        addFrame.add(taskJLabel);
        JTextField taskField = new JTextField(10);
        taskField.setBounds(50,100,200,50);
        addFrame.add(taskField);
        addFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addFrame.setLayout(null);
        JButton addButton = new JButton("Add Task");
        addButton.addActionListener(e ->{addFrame.dispose();taskAddition(tasks,taskField.getText());});
        addButton.setBounds(50,150, 200, 50);
        addFrame.add(addButton);
        addFrame.setSize(WIDTH,HEIGHT);
        addFrame.setVisible(true);
        writeFile(tasks);
    }
    public static void taskAddition(ArrayList<Tasks> tasks, String entry){
        tasks.add(new Tasks(entry, false));
        writeFile(tasks);
        mainList(tasks); 
              
    }
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        String fileName = "Final Project\\Task.txt";
        int counter = 0;
        String chore;
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
        
        mainList(taskList);
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
        myReader.close();
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
    public static void writeFile(ArrayList<Tasks> tasks){
        String entry;
        String delimiter = ",";
        Boolean completed;
        int counter = 0;
        String newLine = "\n";
        String fileName = "Final Project\\Task.txt";
        try {
        FileWriter myWriter = new FileWriter(fileName, false);
        for(counter = 0; counter<tasks.size(); ++counter){
            entry = tasks.get(counter).getTask();
            completed = tasks.get(counter).getCompleted();
            myWriter.write(entry+delimiter);
            if(completed){
                myWriter.write("1");
            }
            else    
                myWriter.write("0");
            myWriter.write(newLine);
        }
        myWriter.close();
        }
        catch(Exception e){
            System.out.println(e + "error");
        }
    }
}