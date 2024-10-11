//Last edit: 10/11/2024
//addTasks.java
//Alexander Cox

import java.util.ArrayList;
import javax.swing.*;
public class addTasks{
    
    public addTasks(ArrayList<Tasks> taskList){
        final int WIDTH = 300;
        final int HEIGHT = 200;
        TaskList addFrame = new TaskList(taskList);
        addFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addFrame.setLayout(null);
        JButton addButton = new JButton("Add Task");
        addButton.setBounds(50,50, 200, 50);
        addFrame.add(addButton);
        addFrame.setSize(WIDTH,HEIGHT);
        addFrame.setVisible(true);
    }
}