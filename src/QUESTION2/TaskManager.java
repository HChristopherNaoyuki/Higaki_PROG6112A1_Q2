package QUESTION2;

// File: TaskManager.java

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The TaskManager class manages a list of tasks, providing operations to add, list,
 * complete, delete, search, and filter tasks. It also supports saving tasks to and
 * loading tasks from a file.
 */

public class TaskManager
{
    private List<Task> tasks;  // List to store tasks

    /**
     * Constructs a new TaskManager with an empty task list.
     */
    public TaskManager()
    {
        tasks = new ArrayList<>();
    }
    
    /**
     * Adds a new task to the task list with the given description, due date, and priority.
     *
     * @param description the description of the task
     * @param dueDate     the due date of the task
     * @param priority    the priority level of the task
     */
    public void addTask(String description, LocalDate dueDate, String priority)
    {
        Task task = new Task(description, dueDate, priority);
        tasks.add(task);
        System.out.println("Task added successfully!");
    }

    /**
     * Lists all tasks in the task list, sorted by priority and due date.
     */
    public void listTasks()
    {
        List<Task> sortedTasks = tasks.stream()
                .sorted(Comparator.comparing(Task::getPriority)
                        .thenComparing(Task::getDueDate))
                .collect(Collectors.toList());

        System.out.println("Tasks:");
        for (Task task : sortedTasks)
        {
            System.out.println(task);
        }
    }

    /**
     * Marks the task with the specified ID as completed.
     *
     * @param id the ID of the task to complete
     */
    public void completeTask(int id)
    {
        for (Task task : tasks)
        {
            if (task.getId() == id)
            {
                task.markCompleted();
                System.out.println("Task marked as completed!");
                return;
            }
        }
        System.out.println("Task not found!");
    }

    /**
     * Deletes the task with the specified ID from the task list.
     *
     * @param id the ID of the task to delete
     */
    public void deleteTask(int id)
    {
        tasks.removeIf(task -> task.getId() == id);
        System.out.println("Task deleted successfully!");
    }

    /**
     * Searches for tasks that contain the specified keyword in their descriptions.
     *
     * @param keyword the keyword to search for
     */
    public void searchTasks(String keyword)
    {
        List<Task> results = tasks.stream()
                .filter(task -> task.getDescription().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());

        System.out.println("Search Results:");
        for (Task task : results)
        {
            System.out.println(task);
        }
    }

    /**
     * Filters tasks based on the given criteria (priority, due date, or status) and value.
     *
     * @param criteria the criteria to filter by (priority, duedate, or status)
     * @param value    the value for the filter criteria
     */
    public void filterTasks(String criteria, String value)
    {
        List<Task> filteredTasks = new ArrayList<>();

        switch (criteria.toLowerCase())
        {
            case "priority":
                filteredTasks = tasks.stream()
                        .filter(task -> task.getPriority().equalsIgnoreCase(value))
                        .collect(Collectors.toList());
                break;
                
            case "duedate":
                LocalDate date = LocalDate.parse(value);
                filteredTasks = tasks.stream()
                        .filter(task -> task.getDueDate().equals(date))
                        .collect(Collectors.toList());
                break;
                
            case "status":
                boolean completed = value.equalsIgnoreCase("completed");
                filteredTasks = tasks.stream()
                        .filter(task -> task.isCompleted() == completed)
                        .collect(Collectors.toList());
                break;
                
            default:
                System.out.println("Invalid filter criteria!");
                return;
        }

        System.out.println("Filtered Tasks:");
        for (Task task : filteredTasks)
        {
            System.out.println(task);
        }
    }

    /**
     * Saves the current task list to a file specified by the filename.
     *
     * @param filename the name of the file to save tasks to
     */
    public void saveTasks(String filename)
    {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename)))
        {
            oos.writeObject(tasks);
            System.out.println("Tasks saved successfully!");
        }
        catch (IOException e)
        {
            System.out.println("Failed to save tasks: " + e.getMessage());
        }
    }

    /**
     * Loads tasks from a file specified by the filename into the task list.
     *
     * @param filename the name of the file to load tasks from
     */
    public void loadTasks(String filename)
    {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename)))
        {
            tasks = (List<Task>) ois.readObject();
            System.out.println("Tasks loaded successfully!");
        }
        catch (IOException | ClassNotFoundException e)
        {
            System.out.println("Failed to load tasks: " + e.getMessage());
        }
    }

    /**
     * Returns the list of tasks (used for testing purposes).
     *
     * @return the list of tasks
     */
    public List<Task> getTasks()
    {
        return tasks;
    }
}
