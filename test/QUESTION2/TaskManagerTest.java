
package QUESTION2;

// File: TaskManagerTest.java

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Author: Naoyuki Christopher Higaki
 * Student Number: ST10462415
 * 
 * The TaskManagerTest class provides unit tests for the Task and TaskManager classes.
 * It verifies operations such as adding tasks, listing tasks, marking tasks as completed,
 * deleting tasks, searching tasks, and filtering tasks.
 */
public class TaskManagerTest {
    private TaskManager taskManager;

    /**
     * Sets up a new TaskManager instance before each test.
     */
    @Before
    public void setUp() {
        taskManager = new TaskManager();
        System.out.println("Setting up a new TaskManager instance.");
    }

    /**
     * Tests if tasks can be added successfully to the TaskManager.
     */
    @Test
    public void testAddTask() {
        System.out.println("Running testAddTask...");
        taskManager.addTask("Test Task 1", LocalDate.now().plusDays(1), "High");
        taskManager.addTask("Test Task 2", LocalDate.now().plusDays(2), "Medium");
        List<Task> tasks = taskManager.getTasks();
        assertEquals(2, tasks.size());
        System.out.println("testAddTask passed.");
    }

    /**
     * Verifies that a task can be marked as completed.
     */
    @Test
    public void testCompleteTask() {
        System.out.println("Running testCompleteTask...");
        taskManager.addTask("Test Task", LocalDate.now().plusDays(1), "High");
        taskManager.completeTask(1);
        Task task = taskManager.getTasks().get(0);
        assertTrue(task.isCompleted());
        System.out.println("testCompleteTask passed.");
    }

    /**
     * Checks if tasks can be deleted by their ID.
     */
    @Test
    public void testDeleteTask() {
        System.out.println("Running testDeleteTask...");
        taskManager.addTask("Test Task", LocalDate.now().plusDays(1), "High");
        taskManager.deleteTask(1);
        assertTrue(taskManager.getTasks().isEmpty());
        System.out.println("testDeleteTask passed.");
    }

    /**
     * Ensures tasks can be searched by keywords in their descriptions.
     */
    @Test
    public void testSearchTasks() {
        System.out.println("Running testSearchTasks...");
        taskManager.addTask("Buy milk", LocalDate.now().plusDays(1), "Low");
        taskManager.addTask("Go to gym", LocalDate.now().plusDays(2), "Medium");
        List<Task> results = taskManager.getTasks().stream()
            .filter(task -> task.getDescription().toLowerCase().contains("milk"))
            .collect(Collectors.toList());
        assertEquals(1, results.size());
        System.out.println("testSearchTasks passed.");
    }

    /**
     * Tests filtering tasks based on priority.
     */
    @Test
    public void testFilterTasksByPriority() {
        System.out.println("Running testFilterTasksByPriority...");
        taskManager.addTask("Task 1", LocalDate.now().plusDays(1), "High");
        taskManager.addTask("Task 2", LocalDate.now().plusDays(2), "Medium");
        List<Task> results = taskManager.getTasks().stream()
            .filter(task -> task.getPriority().equalsIgnoreCase("High"))
            .collect(Collectors.toList());
        assertEquals(1, results.size());
        System.out.println("testFilterTasksByPriority passed.");
    }

    /**
     * Validates filtering tasks by due date.
     */
    @Test
    public void testFilterTasksByDueDate() {
        System.out.println("Running testFilterTasksByDueDate...");
        LocalDate dueDate = LocalDate.now().plusDays(1);
        taskManager.addTask("Task 1", dueDate, "High");
        taskManager.addTask("Task 2", LocalDate.now().plusDays(2), "Medium");
        List<Task> results = taskManager.getTasks().stream()
            .filter(task -> task.getDueDate().equals(dueDate))
            .collect(Collectors.toList());
        assertEquals(1, results.size());
        System.out.println("testFilterTasksByDueDate passed.");
    }

    /**
     * Confirms filtering tasks by completion status.
     */
    @Test
    public void testFilterTasksByStatus() {
        System.out.println("Running testFilterTasksByStatus...");
        taskManager.addTask("Task 1", LocalDate.now().plusDays(1), "High");
        taskManager.completeTask(1);
        List<Task> results = taskManager.getTasks().stream()
            .filter(Task::isCompleted)
            .collect(Collectors.toList());
        assertEquals(1, results.size());
        System.out.println("testFilterTasksByStatus passed.");
    }
}
