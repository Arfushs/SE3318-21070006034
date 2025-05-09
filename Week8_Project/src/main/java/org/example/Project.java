package org.example;

import java.util.ArrayList;
import java.util.List;

public class Project {
    String title;
    List<Task> tasks;
    List<User> users;

    public Project(String title) {
        this.title = title;
        users = new ArrayList<>();
        tasks = new ArrayList<>();
    }

    /**
     * Adds a user to the project's user list
     * @param user the user to be added to the project
     * @effects adds the specified user to the internal list of users
     */

    public void addUser(User user) {
        users.add(user);
    }

    /**
     * Adds a task to the project's task list
     * @param task the task to be added to the project
     * @effects adds the specified task to the internal list of tasks
     */

    public void addTask(Task task) {
        tasks.add(task);
    }

    /**
     * Assigns a task to a user within the project.
     * If the user or task does not exist in the project, they are added
     * @param task the task to assign
     * @param user the user to whom the task is assigned
     * @effects
     *  - Adds the user to the project if not already present
     *  - Adds the task to the project if not already present
     *  - Assigns the task to the user
     */

    public void assignTask(Task task, User user) {
        if (user == null || task == null) {
            System.out.println("Task or user does not exist");
        } else {
            if (!userExists(user)) {
                addUser(user);
            }

            if (!taskExists(task)) {
                addTask(task);
            }

            user.assignTask(task);
            NotificationService ns = new NotificationService(user);
            ns.notifyUser("You have been assigned new task!");
        }
    }

    /**
     * Retrieves a task from the project by its title
     * @param title the title of the task to search for
     * @return the Task object with the matching title, or null if not found
     */

    public Task getTaskByTitle(String title) {
        for (Task task : tasks) {
            if (task.getTitle().equals(title)) {
                return task;
            }
        }
        return null;
    }

    /**
     * Checks whether a given task already exists in the project
     * @param task the Task object to check
     * @return true if the task exists in the project, false otherwise
     */

    public boolean taskExists(Task task) {
        for (Task t : tasks) {
            if (task == t) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks whether the specified user already exists in the project
     * @param user the User object to check
     * @return true if the user exists in the project, false otherwise
     */

    public boolean userExists(User user) {
        for (User u : users) {
            if (user == u) {
                return true;
            }
        }
        return false;
    }
}
