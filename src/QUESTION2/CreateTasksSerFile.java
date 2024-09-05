package QUESTION2;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: NAOYUKI CHRISTOPHER HIGAKI
 * Student Number: ST10462415
 *
 * This class, CreateTasksSerFile, is responsible for generating and serializing a list of tasks.
 * The serialized file created is named "tasks.ser". This file includes a set of sample tasks 
 * to be used by the TaskMaster program for testing purposes. Each task consists of a description, 
 * a due date, and a priority level. These tasks serve as initial test data.
 */
public class CreateTasksSerFile
{
    /**
     * The main method is the entry point of the program. It generates sample tasks and
     * serializes them into a file called "tasks.ser".
     * 
     * Steps:
     * 1. Create a list of tasks with sample data.
     * 2. Serialize the list of tasks using ObjectOutputStream.
     * 3. Handle any exceptions that may occur during file I/O or serialization.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args)
    {
        try
        {
            // Step 1: Create a list to hold Task objects
            List<Task> tasks = new ArrayList<>();
            
            // Step 2: Add sample tasks to the list with description, due date, and priority
            tasks.add(new Task("Finish project", LocalDate.of(2024, 8, 20), "High"));
            tasks.add(new Task("Buy groceries", LocalDate.of(2024, 8, 21), "Medium"));
            tasks.add(new Task("Call John", LocalDate.of(2024, 8, 22), "Low"));

            // Step 3: Serialize the list of tasks into the file "tasks.ser"
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("tasks.ser")))
            {
                oos.writeObject(tasks);  // Write the list of tasks to the file
                System.out.println("tasks.ser file created successfully with sample tasks.");
            }
        }
        catch (Exception e)  // Step 4: Handle exceptions that may occur
        {
            e.printStackTrace();  // Print the stack trace for debugging purposes
        }
    }
}
