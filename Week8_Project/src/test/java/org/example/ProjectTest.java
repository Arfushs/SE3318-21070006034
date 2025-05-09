package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ProjectTest {
    private Project project;
    private User user1;
    private User user2;
    private Task task1;
    private Task task2;

    @BeforeEach
    public void setUp() {
        project = new Project("Project 1");
        user1 = new User("James Hetfield", "james.hetfield@metallica.com");
        user2 = new User("Dave Mustaine", "dave.mustaine@megadeth.com");
        task1 = new Task("Task 1", LocalDate.of(2025, 5, 10));
        task2 = new Task("Task 2", LocalDate.of(2025, 8, 10));
    }

    @Test
    public void testAddUser() {
        project.addUser(user1);
        assertTrue(project.userExists(user1), "User 1 should be in the project");
    }

    @Test
    public void testAddTask() {
        project.addTask(task1);
        assertTrue(project.taskExists(task1), "Task 1 should be in the project");
    }

    @Test
    public void testAssignTaskToUser() {
        project.addUser(user1);
        project.addTask(task1);
        project.assignTask(task1, user1);

        assertTrue(user1.getTaskList().contains(task1), "User 1 should have Task 1 assigned");
    }

    @Test
    public void testAssignTaskWithNewUserAndTask() {
        project.assignTask(task1, user1);

        assertTrue(project.userExists(user1), "User 1 should be in the project");
        assertTrue(project.taskExists(task1), "Task 1 should be in the project");
        assertTrue(user1.getTaskList().contains(task1), "User 1 should have Task 1 assigned");
    }

    @Test
    public void testGetTaskByTitle() {
        project.addTask(task1);
        Task retrievedTask = project.getTaskByTitle("Task 1");

        assertNotNull(retrievedTask, "Task 1 should be found");
        assertEquals("Task 1", retrievedTask.getTitle(), "The retrieved task's title should be 'Task 1'");
    }

    @Test
    public void testAssignTaskWithNonExistentUser() {
        project.addTask(task1);
        project.assignTask(task1, user1);
        assertTrue(user1.getTaskList().contains(task1), "User 1 should have Task 1 assigned");
    }

    @Test
    public void testAssignNullTaskOrUser() {
        project.addUser(user1);
        project.addTask(task1);

        project.assignTask(null, user1);
        assertTrue(user1.getTaskList().isEmpty(), "User 1 should not have any tasks assigned");

        project.assignTask(task1, null);
        assertTrue(task1.userList.isEmpty(), "Task 1 should not have any users assigned");
    }
}
