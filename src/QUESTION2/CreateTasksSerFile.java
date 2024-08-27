
package QUESTION2;

// File: CreateTasksSerFile.java

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: Naoyuki Christopher Higaki
 * Student Number: ST10462415
 *
 * This file is responsible for creating a serialized file named "tasks.ser".
 * It generates a list of sample tasks and serializes them, saving the data
 * to "tasks.ser" so that they can be loaded and used by the TaskMaster program.
 * 
 * The tasks created in this file serve as initial data for testing purposes.
 * Each task includes a description, due date, and priority level.
 */

public class CreateTasksSerFile {

    public static void main(String[] args) {
        try {
            // Create some tasks
            List<Task> tasks = new ArrayList<>();
            tasks.add(new Task("Finish project", LocalDate.of(2024, 8, 20), "High"));
            tasks.add(new Task("Buy groceries", LocalDate.of(2024, 8, 21), "Medium"));
            tasks.add(new Task("Call John", LocalDate.of(2024, 8, 22), "Low"));

            // Serialize the tasks to the file "tasks.ser"
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("tasks.ser"))) {
                oos.writeObject(tasks);
                System.out.println("tasks.ser file created successfully with sample tasks.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
