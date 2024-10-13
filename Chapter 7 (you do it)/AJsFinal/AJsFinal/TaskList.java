
// Last edit: 10/12/2024
// TaskList.java
// Alexander Cox
// Error: throws error if something is in txt file that isn't supposed to
import java.util.ArrayList;
import javax.swing.*;

public class TaskList extends WriteFile {
    static WriteFile fileWriter = new WriteFile();

    public TaskList() {
        super(); // Call the constructor of the parent class
    }

    public static void main(String[] args) {
        ReadFile fileReader = new ReadFile();
        String fileName = "Task.txt";
        int counter = 0;
        String chore;
        Boolean compBool;
        ArrayList<Tasks> taskList = new ArrayList<>();
        ArrayList<Boolean> completionList = new ArrayList<>();
        ArrayList<String> tasks = new ArrayList<>();

        // Read tasks and their completion status from the file
        tasks.addAll(fileReader.ReadFileTask(fileName));
        completionList.addAll(fileReader.ReadFileComp(fileName));

        // Create task objects and add them to the task list
        for (counter = 0; counter < tasks.size(); ++counter) {
            compBool = completionList.get(counter);
            chore = tasks.get(counter);
            taskList.add(new Tasks(chore, compBool));
        }

        // Print tasks and their completion status to the console
        for (counter = 0; counter < taskList.size(); ++counter) {
            System.out.println(taskList.get(counter).getCompleted() + " " + taskList.get(counter).getTask());
        }

        // Display the main task list GUI
        mainList(taskList);
    }

    public static void mainList(ArrayList<Tasks> tasks) {
        ArrayList<JCheckBox> checkList = new ArrayList<>();
        JFrame aFrame = new JFrame();
        int counter = 0;
        final int WIDTH = 350;
        int HEIGHT = 100;
        aFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aFrame.setLayout(null);
        JButton addTaskButton = new JButton("Add a Task");
        JButton removeTaskButton = new JButton("Remove a Task");

        // Create checkboxes for each task and add them to the frame
        for (counter = 0; counter < tasks.size(); ++counter) {
            int y = counter * 35;
            checkList.add(new JCheckBox(tasks.get(counter).getTask(), tasks.get(counter).getCompleted()));
            checkList.get(counter).setBounds(50, y, 1000, 25);
            aFrame.add(checkList.get(counter));

            // Add action listener to update task completion status
            checkList.get(counter).addActionListener(e -> checkBoxes(tasks, checkList));
        }

        // Set bounds for buttons and add them to the frame
        removeTaskButton.setBounds(150, (tasks.size() * 35), 150, 25);
        addTaskButton.setBounds(25, (tasks.size() * 35), 100, 25);
        HEIGHT = (tasks.size() + 1) * 55;
        aFrame.add(removeTaskButton);
        aFrame.add(addTaskButton);
        aFrame.setSize(WIDTH, HEIGHT);
        aFrame.setVisible(true);

        // Quit Button
        JButton quit = new JButton("Quit");
        // Add action listener to close the frame
        quit.addActionListener(e -> aFrame.dispose());
        // Setting bounds
        quit.setBounds(150, (tasks.size() * 35) + 25, 150, 25);
        aFrame.add(quit);

        // Add action listeners for add and remove task buttons
        addTaskButton.addActionListener(e -> {
            aFrame.dispose();
            addTask(tasks);
        });
        removeTaskButton.addActionListener(e -> {
            aFrame.dispose();
            removeTasks(tasks);
        });
    }

    public static void checkBoxes(ArrayList<Tasks> tasks, ArrayList<JCheckBox> checkList) {
        // Update task completion status based on checkbox selection
        for (int counter = 0; counter < tasks.size(); ++counter) {
            String currentTask = tasks.get(counter).getTask();
            Boolean oldCompletion = tasks.get(counter).getCompleted();
            if (oldCompletion != checkList.get(counter).isSelected()) {
                tasks.set(counter, new Tasks(currentTask, checkList.get(counter).isSelected()));
            }
        }
        // Write updated tasks to file
        fileWriter.writeFile(tasks);
    }

    public static void addTask(ArrayList<Tasks> tasks) {
        final int WIDTH = 300;
        final int HEIGHT = 300;
        JFrame addFrame = new JFrame();
        JLabel taskJLabel = new JLabel("Enter a new task");
        taskJLabel.setBounds(50, 50, 200, 50);
        addFrame.add(taskJLabel);
        JTextField taskField = new JTextField(10);
        taskField.setBounds(50, 100, 200, 50);
        addFrame.add(taskField);
        addFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addFrame.setLayout(null);
        JButton addButton = new JButton("Add Task");

        // Add action listener to add the new task
        addButton.addActionListener(e -> {
            addFrame.dispose();
            taskAddition(tasks, taskField.getText());
        });
        addButton.setBounds(50, 150, 200, 50);
        addFrame.add(addButton);
        addFrame.setSize(WIDTH, HEIGHT);
        addFrame.setVisible(true);
        fileWriter.writeFile(tasks);
    }

    public static void taskAddition(ArrayList<Tasks> tasks, String entry) {
        // Add new task to the list and write to file
        tasks.add(new Tasks(entry, false));
        fileWriter.writeFile(tasks);
        mainList(tasks);
    }

    public static void removeTasks(ArrayList<Tasks> tasks) {
        final int WIDTH = 300;
        int HEIGHT = 225 + (tasks.size() * 35);
        JFrame removeFrame = new JFrame();
        JLabel taskJLabel = new JLabel("Enter a task to remove");
        taskJLabel.setBounds(50, 25, 200, 50);
        removeFrame.add(taskJLabel);

        // Display all tasks in the frame
        for (int x = 0; x < tasks.size(); ++x) {
            int y = (x * 35) + 50;
            JLabel taskLabel = new JLabel(tasks.get(x).getTask());
            taskLabel.setBounds(50, y, 1000, 25);
            removeFrame.add(taskLabel);
        }

        JTextField taskField = new JTextField(10);
        taskField.setBounds(50, 75 + tasks.size() * 35, 200, 50);
        removeFrame.add(taskField);
        removeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        removeFrame.setLayout(null);
        JButton addButton = new JButton("Remove Task");

        // Add action listener to remove the specified task
        addButton.addActionListener(e -> {
            removeFrame.dispose();
            taskRemoval(tasks, taskField.getText());
        });
        addButton.setBounds(50, 125 + tasks.size() * 35, 200, 50);
        removeFrame.add(addButton);
        removeFrame.setSize(WIDTH, HEIGHT);
        removeFrame.setVisible(true);
        fileWriter.writeFile(tasks);
    }

    public static void taskRemoval(ArrayList<Tasks> tasks, String entry) {
        // Remove the specified task from the list and write to file
        for (int x = 0; x < tasks.size(); ++x) {
            if (tasks.get(x).getTask().equals(entry)) {
                tasks.remove(x);
            }
        }
        fileWriter.writeFile(tasks);
        mainList(tasks);
    }
}