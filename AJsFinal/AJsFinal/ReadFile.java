import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFile {

    // Method to read tasks from a file and return them as an ArrayList of Strings
    public ArrayList<String> ReadFileTask(String fileTitle) {
        ArrayList<String> tasks = new ArrayList<>(); // Create an ArrayList to store tasks
        String[] tempArray; // Temporary array to hold split data
        try {
            File myObj = new File(fileTitle); // Create a File object for the given file title
            Scanner myReader = new Scanner(myObj); // Create a Scanner object to read the file
            while (myReader.hasNextLine()) { // Loop through each line of the file
                String data = myReader.nextLine(); // Read the current line
                tempArray = data.split(",", 2); // Split the line by the first comma
                tasks.add(tempArray[0]); // Add the first part of the split line to the tasks list
            }
            myReader.close(); // Close the Scanner
        } catch (IOException e) { // Catch any IO exceptions
            System.out.println("An error occurred."); // Print an error message
        }
        return tasks; // Return the list of tasks
    }

    // Method to read completion status from a file and return them as an ArrayList
    // of Booleans
    public ArrayList<Boolean> ReadFileComp(String fileTitle) {
        ArrayList<String> completionNum = new ArrayList<>(); // Create an ArrayList to store completion numbers
        ArrayList<Boolean> completionBol = new ArrayList<>(); // Create an ArrayList to store completion status as
                                                              // Booleans
        String[] tempArrary; // Temporary array to hold split data
        int x; // Loop counter
        try {
            File myObj = new File(fileTitle); // Create a File object for the given file title
            Scanner myReader = new Scanner(myObj); // Create a Scanner object to read the file
            x = 0; // Initialize loop counter
            while (myReader.hasNextLine()) { // Loop through each line of the file
                String data = myReader.nextLine(); // Read the current line
                // Check if the line is not blank and does not start with '\' or ' '
                if (!data.isBlank() && !(data.substring(0, 1).equals("\\")) && !(data.substring(0, 1).equals(" "))) {
                    tempArrary = data.split(",", 2); // Split the line by the first comma
                    if (tempArrary.length == 2) { // Check if the split line has two parts
                        completionNum.add(tempArrary[1]); // Add the second part of the split line to the completionNum
                                                          // list
                    }
                }
            }
            myReader.close(); // Close the Scanner
            // Convert completion numbers to Booleans
            for (x = 0; x < completionNum.size(); ++x) {
                if (completionNum.get(x).equals("0")) { // If the completion number is "0"
                    completionBol.add(false); // Add false to the completionBol list
                } else {
                    completionBol.add(true); // Add true to the completionBol list
                }
            }
        } catch (IOException e) { // Catch any IO exceptions
            System.out.println("An error occurred."); // Print an error message
        }
        return completionBol; // Return the list of completion status as Booleans
    }
}
