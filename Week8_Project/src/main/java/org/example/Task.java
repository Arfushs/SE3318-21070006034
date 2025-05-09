package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Task {
    String title;
    LocalDate dueDate;
    boolean completionStatus;
    List<User> userList;

    public Task(String title, LocalDate dueDate) {
        this.title = title;
        this.dueDate = dueDate;
        completionStatus = false;
        userList = new ArrayList<>();
    }

    /**
     * effects : returns true for completionStatus
     */

    public void markAsCompleted() {
        completionStatus = true;
    }

    /**
     * A task is considered overdue if it has not been completed and its due date is before the current date.
     * @return true if the task is overdue, false otherwise
     */

    public boolean markAsOverdue() {
        return !completionStatus && dueDate.isBefore(LocalDate.now());
    }

    /**
     * @param user
     * requires : user should not be null and task is not in user's taskList
     * effects : task is added to user's taskList
     */

    public void assignTask(User user) {
        if (user == null) {
            System.out.println("User does not exist");
        } else if (!user.taskExists(this)) {
            userList.add(user);
            user.taskList.add(this);
        } else {
            System.out.println("Task already exists");
        }
    }

    /**
     * @return String title of the task
     */

    public String getTitle() {
        return this.title;
    }
}
