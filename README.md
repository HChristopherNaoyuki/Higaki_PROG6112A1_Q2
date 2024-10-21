# Task Management Program: Step-by-Step Guide

Welcome to the Task Management Program! This guide will help you get started with managing your tasks using simple commands. Follow the steps below to learn how to add tasks, view them, and keep track of what you've completed.

--------------------------------------------------------------------
## How to Use the Program:
--------------------------------------------------------------------

1. **Starting the Program**
   - **What You Need**: Before starting, make sure you have access to a terminal (Command Prompt on Windows, Terminal on macOS/Linux) or an IDE (like NetBeans).
   - **How to Start**: Run the program by executing the TaskMaster class. If you're using an IDE, simply click the "Run" button.
   - **Welcome Message**: After the program starts, you’ll see a message saying: `Welcome to TaskMaster!`

2. **Entering Commands**
   - The program will wait for you to type a command. This is where you control what the program does.
   - **Prompt**: You’ll see `Enter a command:`. After this prompt, you can type one of the commands below.

3. **Adding a Task**
   - **Purpose**: Add a new task with details like what needs to be done, when it's due, and how important it is.
   - **Command**: `add-task "description" dueDate priority`
   - **Example**: `add-task "Finish homework" 2024-08-15 High`
   - **Explanation**:
     - `"Finish homework"`: The description of your task (in quotes).
     - `2024-08-15`: The due date for your task (format: `YYYY-MM-DD`).
     - `High`: The priority of your task (can be `High`, `Medium`, or `Low`).
   - **What Happens Next**: The program will confirm by saying, `Task added successfully!`

4. **Listing All Tasks**
   - **Purpose**: View all the tasks you’ve added, along with their details.
   - **Command**: `list-tasks`
   - **What You’ll See**: A list of all tasks, showing:
     - **ID**: A unique number for each task.
     - **Description**: What the task is about.
     - **Due Date**: When the task is due.
     - **Priority**: How important the task is.
     - **Completed**: Whether the task is finished or not.
   - **Example Output**:
     ```
     Tasks:
     ID: 1, Description: Finish homework, Due Date: 2024-08-15, Priority: High, Completed: No
     ```

5. **Marking a Task as Completed**
   - **Purpose**: Mark a task as finished when you’ve completed it.
   - **Command**: `complete-task taskId`
   - **Example**: `complete-task 1`
   - **Explanation**:
     - `1`: The ID of the task you’ve completed (you can find this by listing tasks).
   - **What Happens Next**: The program will confirm by saying, `Task marked as completed!`

6. **Deleting a Task**
   - **Purpose**: Remove a task from your list when it’s no longer needed.
   - **Command**: `delete-task taskId`
   - **Example**: `delete-task 1`
   - **Explanation**:
     - `1`: The ID of the task you want to delete.
   - **What Happens Next**: The program will confirm by saying, `Task deleted successfully!`

7. **Searching for a Task**
   - **Purpose**: Quickly find tasks that mention a specific word or phrase.
   - **Command**: `search-tasks keyword`
   - **Example**: `search-tasks homework`
   - **Explanation**:
     - `homework`: The word you’re looking for in task descriptions.
   - **What Happens Next**: The program will show all tasks that include the keyword you searched for.

8. **Filtering Tasks**
   - **Purpose**: Focus on tasks that meet specific criteria, like those due on a certain date or with a certain priority.
   - **Command**: `filter-tasks criteria value`
   - **Examples**:
     - **By Priority**: `filter-tasks priority High` - Shows only tasks with high priority.
     - **By Due Date**: `filter-tasks duedate 2024-08-15` - Shows only tasks due on August 15, 2024.
     - **By Status**: `filter-tasks status completed` - Shows only tasks that are completed.
   - **What Happens Next**: The program will list all tasks that match your filter.

9. **Exiting the Program**
   - **Purpose**: Save your tasks and close the program.
   - **Command**: `exit`
   - **What Happens Next**:
     - Your tasks are saved to a file called `tasks.ser`, so they’re available the next time you start the program.
     - You’ll see a message saying, `Goodbye!`, and the program will close.

--------------------------------------------------------------------
## Example Session:
--------------------------------------------------------------------

- Welcome to TaskMaster!
- Enter a command:
- add-task "Finish project" 2024-08-20 High
- Task added successfully!

- Enter a command:
- add-task "Buy groceries" 2024-08-21 Medium
- Task added successfully!

- Enter a command:
- list-tasks
- Tasks:
- ID: 1, Description: Finish project, Due Date: 2024-08-20, Priority: High, Completed: No
- ID: 2, Description: Buy groceries, Due Date: 2024-08-21, Priority: Medium, Completed: No

- Enter a command:
- complete-task 1
- Task marked as completed!

- Enter a command:
- filter-tasks status completed
- Filtered Tasks:
- ID: 1, Description: Finish project, Due Date: 2024-08-20, Priority: High, Completed: Yes

- Enter a command:
- exit
- Tasks saved successfully!
- Goodbye!

--------------------------------------------------------------------
## Tips for Success:
--------------------------------------------------------------------

- **Be Careful with Spelling**: Commands need to be typed exactly as shown. If you make a mistake, you might get an error message.
- **Use Quotes for Descriptions**: Always put the task description in quotes when adding a task.
- **Remember Task IDs**: Each task has a unique ID that you use to complete or delete it.

--------------------------------------------------------------------
## Troubleshooting:
--------------------------------------------------------------------

- **Error Messages**: If you see an error, double-check your command for spelling and format.
- **No Tasks Found**: If you filter or search and find nothing, there might be no tasks that match your criteria. Check what you typed and try again.
