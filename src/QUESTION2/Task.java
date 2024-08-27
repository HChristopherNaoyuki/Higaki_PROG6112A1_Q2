
package QUESTION2;

// File: Task.java

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Author: Naoyuki Christopher Higaki
 * Student Number: ST10462415
 * 
 * The Task class represents a single task with a unique ID, description, due date,
 * priority level, and completion status. It provides methods to access and modify
 * these properties.
 */

public class Task implements Serializable {
    private static int idCounter = 1;  // Static counter to ensure unique task IDs
    private final int id;  // Unique identifier for the task
    private String description;  // Description of the task
    private LocalDate dueDate;  // Due date for the task
    private String priority;  // Priority level (e.g., high, medium, low)
    private boolean isCompleted;  // Completion status of the task

    /**
     * Constructs a new Task with the specified description, due date, and priority.
     *
     * @param description the description of the task
     * @param dueDate     the due date of the task
     * @param priority    the priority level of the task
     */
    public Task(String description, LocalDate dueDate, String priority) {
        this.id = idCounter++;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.isCompleted = false;  // Default to not completed
    }

    /**
     * Returns the unique identifier for this task.
     *
     * @return the task ID
     */
    public int getId() {
        return id;
    }

    /**
     * Retrieves the description of this task.
     *
     * @return the task description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Updates the description of this task.
     *
     * @param description the new description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns the due date of this task.
     *
     * @return the due date
     */
    public LocalDate getDueDate() {
        return dueDate;
    }

    /**
     * Updates the due date of this task.
     *
     * @param dueDate the new due date
     */
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * Retrieves the priority level of this task.
     *
     * @return the priority level
     */
    public String getPriority() {
        return priority;
    }

    /**
     * Updates the priority level of this task.
     *
     * @param priority the new priority level
     */
    public void setPriority(String priority) {
        this.priority = priority;
    }

    /**
     * Checks if the task is completed.
     *
     * @return true if the task is completed, false otherwise
     */
    public boolean isCompleted() {
        return isCompleted;
    }

    /**
     * Marks the task as completed.
     */
    public void markCompleted() {
        this.isCompleted = true;
    }

    /**
     * Returns a string representation of the task, including its ID, description,
     * due date, priority level, and completion status.
     *
     * @return a string representation of the task
     */
    @Override
    public String toString() {
        return String.format("ID: %d, Description: %s, Due Date: %s, Priority: %s, Completed: %s",
                id, description, dueDate, priority, isCompleted ? "Yes" : "No");
    }
}
