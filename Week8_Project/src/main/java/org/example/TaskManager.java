package org.example;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    public void removeTask(User user, Task task) {
        user.removeTask(task);
    }

    /**
     * Lists all tasks assigned to a specific user
     * @param user the User whose tasks should be listed
     * @effects prints the title of each task assigned to the user in the format:
     *          "index - task title", starting from index 1
     */

    public void listTasks(User user) {
        int i = 1;
        for (Task t : user.getTaskList()) {
            System.out.println(i + "-" + t.getTitle());
            i++;
        }
    }
}
