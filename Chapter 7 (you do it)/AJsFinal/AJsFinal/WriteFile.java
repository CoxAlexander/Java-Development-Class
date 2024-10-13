import java.io.FileWriter;
import java.util.ArrayList;

public class WriteFile {
    // Method to write tasks to a file
    public void writeFile(ArrayList<Tasks> tasks) {
        String entry;
        String delimiter = ",";
        Boolean completed;
        int counter = 0;
        String newLine = "\n";
        String fileName = "Task.txt";

        try {
            // Create a FileWriter object to write to the file
            FileWriter myWriter = new FileWriter(fileName, false);

            // Loop through each task in the list
            for (counter = 0; counter < tasks.size(); ++counter) {
                // Get the task description
                entry = tasks.get(counter).getTask();
                // Get the task completion status
                completed = tasks.get(counter).getCompleted();

                // Write the task description followed by a delimiter
                myWriter.write(entry + delimiter);

                // Write '1' if the task is completed, otherwise '0'
                if (completed) {
                    myWriter.write("1");
                } else {
                    myWriter.write("0");
                }

                // Write a new line character to separate entries
                myWriter.write(newLine);
            }

            // Close the FileWriter
            myWriter.close();
        } catch (Exception e) {
            // Print the exception message if an error occurs
            System.out.println(e + "error");
        }
    }
}
