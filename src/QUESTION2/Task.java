package QUESTION2;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * The Task class models a single task with attributes such as description, due date,
 * priority level, and completion status. Each task has a unique ID assigned automatically 
 * when created. This class implements Serializable, enabling the task to be serialized 
 * and stored. It provides getter and setter methods to access and update the task's 
 * properties, as well as a method to mark the task as completed.
 */
public class Task implements Serializable
{
    private static int idCounter = 1;  // Static counter to ensure unique task IDs across instances
    private final int id;  // Unique identifier for each task
    private String description;  // A brief description of the task
    private LocalDate dueDate;  // The date by which the task should be completed
    private String priority;  // The urgency of the task (e.g., High, Medium, Low)
    private boolean isCompleted;  // Status flag to track if the task is completed

    /**
     * Constructor for the Task class.
     * Initializes a new Task object with the given description, due date, and priority.
     * The task is assigned a unique ID, and its completion status is initially set to false.
     *
     * @param description A brief summary of the task to be performed
     * @param dueDate The date by which the task is due to be completed
     * @param priority The urgency of the task, defined as a string (e.g., High, Medium, Low)
     */
    public Task(String description, LocalDate dueDate, String priority)
    {
        this.id = idCounter++;  // Automatically assign a unique ID to the task
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.isCompleted = false;  // Initially set the task as not completed
    }

    /**
     * Retrieves the unique ID of the task.
     *
     * @return The ID associated with this task
     */
    public int getId()
    {
        return id;
    }

    /**
     * Retrieves the description of the task.
     *
     * @return A string containing the task's description
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * Updates the description of the task.
     *
     * @param description A new description for the task
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    /**
     * Retrieves the due date of the task.
     *
     * @return A LocalDate object representing the task's due date
     */
    public LocalDate getDueDate()
    {
        return dueDate;
    }

    /**
     * Updates the due date of the task.
     *
     * @param dueDate A new LocalDate representing the task's updated due date
     */
    public void setDueDate(LocalDate dueDate)
    {
        this.dueDate = dueDate;
    }

    /**
     * Retrieves the priority level of the task.
     *
     * @return A string representing the task's priority level
     */
    public String getPriority()
    {
        return priority;
    }

    /**
     * Updates the priority level of the task.
     *
     * @param priority The new priority level (e.g., High, Medium, Low)
     */
    public void setPriority(String priority)
    {
        this.priority = priority;
    }

    /**
     * Checks if the task is completed or not.
     *
     * @return true if the task is marked as completed, false otherwise
     */
    public boolean isCompleted()
    {
        return isCompleted;
    }

    /**
     * Marks the task as completed.
     * This method sets the task's completion status to true.
     */
    public void markCompleted()
    {
        this.isCompleted = true;  // Set the task as completed
    }

    /**
     * Returns a string representation of the task.
     * The string includes the task's unique ID, description, due date, priority level,
     * and completion status.
     *
     * @return A string that summarizes the task's properties
     */
    @Override
    public String toString()
    {
        return String.format(
            "ID: %d, Description: %s, Due Date: %s, Priority: %s, Completed: %s",
            id, description, dueDate, priority, isCompleted ? "Yes" : "No");
    }
}
