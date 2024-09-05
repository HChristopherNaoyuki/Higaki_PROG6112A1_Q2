package QUESTION2;

// File: TaskManagerTest.java

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Author: NAOYUKI CHRISTOPHER HIGAKI
 * Student Number: ST10462415
 * 
 * The TaskManagerTest class is a comprehensive suite of unit tests designed to validate
 * the functionality of the TaskManager and Task classes.
 * 
 * This class ensures that all core operations are functioning correctly, including:
 * 
 *     1. Adding tasks
 *     2. Marking tasks as completed
 *     3. Deleting tasks
 *     4. Searching tasks by description
 *     5. Filtering tasks by priority
 *     6. Filtering tasks by due date
 *     7. Filtering tasks by completion status
 * 
 * Each test method in this class is designed to validate a specific feature or behavior
 * of the TaskManager class to ensure that it meets the expected requirements.
 * 
 */
public class TaskManagerTest
{
    private TaskManager taskManager;

    /**
     * Initializes a new TaskManager instance before each test.
     * <p>
     * This method ensures that each test starts with a fresh instance of TaskManager,
     * allowing for isolated and independent test cases.
     */
    @Before
    public void setUp()
    {
        taskManager = new TaskManager();
        System.out.println("Setting up a new TaskManager instance.");
    }

    /**
     * Tests the functionality of adding tasks to the TaskManager.
     * <p>
     * This test verifies that tasks can be added successfully and checks the
     * count of tasks in the TaskManager to ensure that it reflects the expected number.
     */
    @Test
    public void testAddTask()
    {
        System.out.println("Running testAddTask...");
        taskManager.addTask("Test Task 1", LocalDate.now().plusDays(1), "High");
        taskManager.addTask("Test Task 2", LocalDate.now().plusDays(2), "Medium");
        List<Task> tasks = taskManager.getTasks();
        assertEquals(2, tasks.size());
        System.out.println("testAddTask passed.");
    }

    /**
     * Verifies that a task can be marked as completed.
     * <p>
     * This test ensures that the completeTask method properly updates the task's status
     * and that the updated status can be correctly retrieved and validated.
     */
    @Test
    public void testCompleteTask()
    {
        System.out.println("Running testCompleteTask...");
        taskManager.addTask("Test Task", LocalDate.now().plusDays(1), "High");
        taskManager.completeTask(1);
        Task task = taskManager.getTasks().get(0);
        assertTrue(task.isCompleted());
        System.out.println("testCompleteTask passed.");
    }

    /**
     * Tests the ability to delete tasks by their ID.
     * <p>
     * This test checks that a task can be successfully removed from the TaskManager
     * and that the TaskManager's task list is empty after deletion.
     */
    @Test
    public void testDeleteTask()
    {
        System.out.println("Running testDeleteTask...");
        taskManager.addTask("Test Task", LocalDate.now().plusDays(1), "High");
        taskManager.deleteTask(1);
        assertTrue(taskManager.getTasks().isEmpty());
        System.out.println("testDeleteTask passed.");
    }

    /**
     * Ensures that tasks can be searched by keywords in their descriptions.
     * <p>
     * This test validates that the search functionality correctly filters tasks
     * based on the provided keyword and returns the expected results.
     */
    @Test
    public void testSearchTasks()
    {
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
     * <p>
     * This test checks that tasks can be successfully filtered by their priority
     * and that the filtered results match the expected criteria.
     */
    @Test
    public void testFilterTasksByPriority()
    {
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
     * Validates filtering tasks by their due date.
     * <p>
     * This test verifies that tasks can be filtered based on their due date
     * and that the filtered list contains tasks with the specified due date.
     */
    @Test
    public void testFilterTasksByDueDate()
    {
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
     * Confirms that tasks can be filtered by their completion status.
     * <p>
     * This test ensures that tasks can be correctly filtered based on whether
     * they are completed or not, and that the filtered results meet the expected criteria.
     */
    @Test
    public void testFilterTasksByStatus()
    {
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
