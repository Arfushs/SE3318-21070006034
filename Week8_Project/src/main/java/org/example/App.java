package org.example;

import java.time.LocalDate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        User user1 = new User("Dave Mustaine", "dave.mustaine@megadeth.com");
        User user2 = new User("James Hetfield", "james.hetfield@metallica.com");

        Task task1 = new Task("Complete project report", LocalDate.of(2025, 5, 10));
        Task task2 = new Task("Attend team meeting", LocalDate.of(2025, 4, 15));
        Task task3 = new Task("Update project documentation", LocalDate.of(2025, 6, 1));

        Project project = new Project("Project Alpha");

        project.addUser(user1);
        project.addUser(user2);

        project.addTask(task1);
        project.addTask(task2);
        project.addTask(task3);

        project.assignTask(task1, user1);
        project.assignTask(task2, user2);
        project.assignTask(task3, user1);

        TaskManager taskManager = new TaskManager();
        taskManager.listTasks(user1);
        taskManager.listTasks(user2);

        task1.markAsCompleted();

        user2.removeTask(task2);
        taskManager.listTasks(user1);
    }
}
