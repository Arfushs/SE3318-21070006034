package org.example;

import java.util.ArrayList;
import java.util.List;

public class User {
    String username;
    String emailAddress;
    List<Task> taskList;

    public User(String username, String emailAddress) {
        this.username = username;
        this.emailAddress = emailAddress;
        taskList = new ArrayList<>();
    }

    /**
     * Assigns a task to the user by adding it to the user's task list
     * @param task the Task to assign to the user
     * @effects adds the specified task to the user's task list
     */

    public void assignTask(Task task) {
        taskList.add(task);
    }

    /**
     * Removes a task from the user's task list
     * @param task the Task to be removed from the user's task list
     * @requires task != null
     * @effects removes the specified task from the user's task list if it exists
     *          otherwise, prints an error message stating "Task does not exist"
     */

    public void removeTask(Task task) {
        if (task == null) {
            System.out.println("Task does not exist");
            return;
        }

        boolean taskFound = false;
        for (Task t : taskList) {
            if (task == t) {
                taskList.remove(task);
                taskFound = true;
                break;
            }
        }

        if (!taskFound) {
            System.out.println("Task does not exist");
        }
    }

    /**
     * Checks whether the specified task exists in the user's task list
     * @param task the Task to check for existence in the task list
     * @return true if the task is found in the task list, false otherwise
     */

    public boolean taskExists(Task task) {
        for (Task t : taskList) {
            if (task == t) {
                return true;
            }
        }
        return false;
    }

    /**
     * Retrieves the list of tasks assigned to the user
     * @return a List of Task objects representing the tasks assigned to the user
     */

    public List<Task> getTaskList() {
        return taskList;
    }

    /**
     * Displays the notification message to the user
     * @param message the notification message to be displayed
     */

    public void getNotification(String message) {
        System.out.println(message);
    }
}
