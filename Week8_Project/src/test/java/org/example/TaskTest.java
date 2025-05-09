package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {
    private Task task;
    private User user;

    @BeforeEach
    public void setUp() {
        task = new Task("Test Task", LocalDate.of(2025, 5, 10));
        user = new User("James Hetfield", "james.hetfield@metallica.com");
    }

    @Test
    public void testMarkAsCompleted() {
        task.markAsCompleted();
        assertTrue(task.completionStatus, "Task should be marked as completed.");
    }

    @Test
    public void testMarkAsOverdue_NotOverdue() {
        task.markAsCompleted();
        assertFalse(task.markAsOverdue(), "Task should not be overdue after completion.");
    }

    @Test
    public void testMarkAsOverdue_Overdue() {
        Task task = new Task("Test Task", LocalDate.of(2022, 1, 1));
        boolean result = task.markAsOverdue();
        assertTrue(result, "Task should be overdue.");
    }


    @Test
    public void testAssignTask_Success() {
        task.assignTask(user);
        assertTrue(user.taskExists(task), "User should have the task assigned.");
    }

    @Test
    public void testAssignTask_TaskAlreadyAssigned() {
        task.assignTask(user);
        task.assignTask(user);
        assertEquals(1, user.getTaskList().size(), "Task should only be added once.");
    }

    @Test
    public void testAssignTask_NullUser() {
        task.assignTask(null);
        assertFalse(user.taskExists(task), "Task should not be assigned to null user.");
    }
}
