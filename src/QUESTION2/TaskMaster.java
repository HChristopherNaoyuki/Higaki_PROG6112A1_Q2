package QUESTION2;

// File: TaskMaster.java

import java.time.LocalDate;
import java.util.Scanner;

/**
 * Author:
 * Student Number:
 *
 * Task Management Program: Step-by-Step Guide
 *
 * Welcome to the Task Management Program! This guide will help you get started with managing your tasks using simple commands.
 * Follow the steps below to learn how to add tasks, view them, and keep track of what you've completed.
 *
 * --------------------------------------------------------------------
 * How to Use the Program:
 * --------------------------------------------------------------------
 *
 * 1. **Starting the Program**
 *    - **What You Need**: Before starting, make sure you have access to a terminal (Command Prompt on Windows, Terminal on macOS/Linux) or an IDE (like NetBeans).
 *    - **How to Start**: Run the program by executing the TaskMaster class. If you're using an IDE, simply click the "Run" button.
 *    - **Welcome Message**: After the program starts, you’ll see a message saying: `Welcome to TaskMaster!`
 *
 * 2. **Entering Commands**
 *    - The program will wait for you to type a command. This is where you control what the program does.
 *    - **Prompt**: You’ll see `Enter a command:`. After this prompt, you can type one of the commands below.
 *
 * 3. **Adding a Task**
 *    - **Purpose**: Add a new task with details like what needs to be done, when it's due, and how important it is.
 *    - **Command**: `add-task "description" dueDate priority`
 *    - **Example**: `add-task "Finish homework" 2024-08-15 High`
 *    - **Explanation**:
 *      - `"Finish homework"`: The description of your task (in quotes).
 *      - `2024-08-15`: The due date for your task (format: `YYYY-MM-DD`).
 *      - `High`: The priority of your task (can be `High`, `Medium`, or `Low`).
 *    - **What Happens Next**: The program will confirm by saying, `Task added successfully!`
 *
 * 4. **Listing All Tasks**
 *    - **Purpose**: View all the tasks you’ve added, along with their details.
 *    - **Command**: `list-tasks`
 *    - **What You’ll See**: A list of all tasks, showing:
 *      - **ID**: A unique number for each task.
 *      - **Description**: What the task is about.
 *      - **Due Date**: When the task is due.
 *      - **Priority**: How important the task is.
 *      - **Completed**: Whether the task is finished or not.
 *    - **Example Output**:
 *      ```
 *      Tasks:
 *      ID: 1, Description: Finish homework, Due Date: 2024-08-15, Priority: High, Completed: No
 *      ```
 *
 * 5. **Marking a Task as Completed**
 *    - **Purpose**: Mark a task as finished when you’ve completed it.
 *    - **Command**: `complete-task taskId`
 *    - **Example**: `complete-task 1`
 *    - **Explanation**:
 *      - `1`: The ID of the task you’ve completed (you can find this by listing tasks).
 *    - **What Happens Next**: The program will confirm by saying, `Task marked as completed!`
 *
 * 6. **Deleting a Task**
 *    - **Purpose**: Remove a task from your list when it’s no longer needed.
 *    - **Command**: `delete-task taskId`
 *    - **Example**: `delete-task 1`
 *    - **Explanation**:
 *      - `1`: The ID of the task you want to delete.
 *    - **What Happens Next**: The program will confirm by saying, `Task deleted successfully!`
 *
 * 7. **Searching for a Task**
 *    - **Purpose**: Quickly find tasks that mention a specific word or phrase.
 *    - **Command**: `search-tasks keyword`
 *    - **Example**: `search-tasks homework`
 *    - **Explanation**:
 *      - `homework`: The word you’re looking for in task descriptions.
 *    - **What Happens Next**: The program will show all tasks that include the keyword you searched for.
 *
 * 8. **Filtering Tasks**
 *    - **Purpose**: Focus on tasks that meet specific criteria, like those due on a certain date or with a certain priority.
 *    - **Command**: `filter-tasks criteria value`
 *    - **Examples**:
 *      - **By Priority**: `filter-tasks priority High` - Shows only tasks with high priority.
 *      - **By Due Date**: `filter-tasks duedate 2024-08-15` - Shows only tasks due on August 15, 2024.
 *      - **By Status**: `filter-tasks status completed` - Shows only tasks that are completed.
 *    - **What Happens Next**: The program will list all tasks that match your filter.
 *
 * 9. **Exiting the Program**
 *    - **Purpose**: Save your tasks and close the program.
 *    - **Command**: `exit`
 *    - **What Happens Next**:
 *      - Your tasks are saved to a file called `tasks.ser`, so they’re available the next time you start the program.
 *      - You’ll see a message saying, `Goodbye!`, and the program will close.
 *
 * --------------------------------------------------------------------
 * Example Session:
 * --------------------------------------------------------------------
 * 
 * Welcome to TaskMaster!
 * Enter a command:
 * add-task "Finish project" 2024-08-20 High
 * Task added successfully!
 *
 * Enter a command:
 * add-task "Buy groceries" 2024-08-21 Medium
 * Task added successfully!
 *
 * Enter a command:
 * list-tasks
 * Tasks:
 * ID: 1, Description: Finish project, Due Date: 2024-08-20, Priority: High, Completed: No
 * ID: 2, Description: Buy groceries, Due Date: 2024-08-21, Priority: Medium, Completed: No
 *
 * Enter a command:
 * complete-task 1
 * Task marked as completed!
 *
 * Enter a command:
 * filter-tasks status completed
 * Filtered Tasks:
 * ID: 1, Description: Finish project, Due Date: 2024-08-20, Priority: High, Completed: Yes
 *
 * Enter a command:
 * exit
 * Tasks saved successfully!
 * Goodbye!
 *
 * --------------------------------------------------------------------
 * Tips for Success:
 * --------------------------------------------------------------------
 * 
 * - **Be Careful with Spelling**: Commands need to be typed exactly as shown. If you make a mistake, you might get an error message.
 * - **Use Quotes for Descriptions**: Always put the task description in quotes when adding a task.
 * - **Remember Task IDs**: Each task has a unique ID that you use to complete or delete it.
 *
 * --------------------------------------------------------------------
 * Troubleshooting:
 * --------------------------------------------------------------------
 * 
 * - **Error Messages**: If you see an error, double-check your command for spelling and format.
 * - **No Tasks Found**: If you filter or search and find nothing, there might be no tasks that match your criteria. Check what you typed and try again.
 *
 */

public class TaskMaster
{
    // The filename where tasks will be saved/loaded
    private static final String FILENAME = "tasks.ser";

    // The TaskManager instance that handles all task operations
    private static TaskManager taskManager;

    // The Scanner instance to read user input from the command line
    private static Scanner scanner;

    /**
     * The entry point of the application. Initializes the TaskManager, loads existing tasks from file,
     * and processes user commands until the user exits the application.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args)
    {
        // Initialize TaskManager and Scanner
        taskManager = new TaskManager();
        scanner = new Scanner(System.in);

        // Load tasks from the file (if any)
        taskManager.loadTasks(FILENAME);

        System.out.println("Welcome to TaskMaster!");

        // Main loop to process user commands until 'exit' is entered
        boolean exit = false;

        while (!exit)
        {
            System.out.println("Enter a command:");
            String command = scanner.nextLine();

            // Split the command into the command name and arguments
            String[] parts = command.split(" ", 2);

            // Handle different commands
            switch (parts[0].toLowerCase())
            {
                case "add-task":
                    // Check if there are enough arguments for adding a task
                    if (parts.length > 1)
                    {
                        handleAddTask(parts[1]);
                    }
                    else
                    {
                        System.out.println("Error: 'add-task' command requires additional arguments.");
                    }

                    break;

                case "list-tasks":
                    // List all tasks
                    taskManager.listTasks();
                    break;

                case "complete-task":
                    // Check if there is a task ID provided
                    if (parts.length > 1)
                    {
                        handleCompleteTask(parts[1]);
                    }
                    else
                    {
                        System.out.println("Error: 'complete-task' command requires a task ID.");
                    }

                    break;

                case "delete-task":
                    // Check if there is a task ID provided
                    if (parts.length > 1)
                    {
                        handleDeleteTask(parts[1]);
                    }
                    else
                    {
                        System.out.println("Error: 'delete-task' command requires a task ID.");
                    }

                    break;

                case "search-tasks":
                    // Check if there is a keyword provided for searching
                    if (parts.length > 1)
                    {
                        handleSearchTasks(parts[1]);
                    }
                    else
                    {
                        System.out.println("Error: 'search-tasks' command requires a keyword.");
                    }

                    break;

                case "filter-tasks":
                    // Check if there are enough arguments for filtering tasks
                    if (parts.length > 1)
                    {
                        handleFilterTasks(parts[1]);
                    }
                    else
                    {
                        System.out.println("Error: 'filter-tasks' command requires filter criteria and a value.");
                    }

                    break;

                case "exit":
                    // Exit the application and save tasks to file
                    exit = true;
                    taskManager.saveTasks(FILENAME);
                    break;

                default:
                    // Handle unknown commands
                    System.out.println("Unknown command! Try again.");
                    break;
            }
        }

        // Print a goodbye message when exiting
        System.out.println("Goodbye!");
    }

    /**
     * Handles the 'add-task' command by parsing the task details and adding the task to the TaskManager.
     *
     * @param details the details of the task in the format: "description" dueDate priority
     */
    private static void handleAddTask(String details)
    {
        // Split the details by double quotes to extract the description
        String[] parts = details.split("\"");

        if (parts.length < 2)
        {
            System.out.println("Invalid command format!");
            return;
        }

        // Extract the description
        String description = parts[1].trim();

        // Split the remaining part to get the due date and priority
        String[] rest = parts[2].trim().split(" ");

        if (rest.length < 2)
        {
            System.out.println("Invalid command format!");
            return;
        }

        // Parse the due date and priority
        LocalDate dueDate = LocalDate.parse(rest[0].trim());
        String priority = rest[1].trim();

        // Add the task using the TaskManager
        taskManager.addTask(description, dueDate, priority);
    }

    /**
     * Handles the 'complete-task' command by marking the specified task as completed.
     *
     * @param taskIdStr the ID of the task to complete
     */
    private static void handleCompleteTask(String taskIdStr)
    {
        try
        {
            // Parse the task ID from the input string
            int taskId = Integer.parseInt(taskIdStr.trim());

            // Mark the task as completed using the TaskManager
            taskManager.completeTask(taskId);
        }
        catch (NumberFormatException e)
        {
            // Handle invalid task ID input
            System.out.println("Invalid task ID!");
        }
    }

    /**
     * Handles the 'delete-task' command by deleting the specified task.
     *
     * @param taskIdStr the ID of the task to delete
     */
    private static void handleDeleteTask(String taskIdStr)
    {
        try
        {
            // Parse the task ID from the input string
            int taskId = Integer.parseInt(taskIdStr.trim());

            // Delete the task using the TaskManager
            taskManager.deleteTask(taskId);
        }
        catch (NumberFormatException e)
        {
            // Handle invalid task ID input
            System.out.println("Invalid task ID!");
        }
    }

    /**
     * Handles the 'search-tasks' command by searching for tasks containing the specified keyword.
     *
     * @param keyword the keyword to search for in task descriptions
     */
    private static void handleSearchTasks(String keyword)
    {
        // Search for tasks using the TaskManager
        taskManager.searchTasks(keyword.trim());
    }

    /**
     * Handles the 'filter-tasks' command by filtering tasks based on the specified criteria and value.
     *
     * @param filterCriteria the filter criteria in the format: criteria value
     */
    private static void handleFilterTasks(String filterCriteria)
    {
        // Split the filter criteria into the criteria and value
        String[] parts = filterCriteria.split(" ", 2);

        if (parts.length < 2)
        {
            System.out.println("Invalid command format!");
            return;
        }

        // Extract the criteria and value
        String criteria = parts[0].trim();
        String value = parts[1].trim();

        // Filter tasks using the TaskManager
        taskManager.filterTasks(criteria, value);
    }
}
