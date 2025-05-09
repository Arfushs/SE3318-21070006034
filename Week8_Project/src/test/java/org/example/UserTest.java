package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;

public class UserTest {

    private User user;
    private Task task1;
    private Task task2;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        user = new User("James Hetfield", "james.hetfield@metallica.com");
        task1 = new Task("Task 1", LocalDate.of(2025, 5, 10));
        task2 = new Task("Task 2", LocalDate.of(2025, 8, 10));
        user.assignTask(task1);
        user.assignTask(task2);
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void testAssignTask() {
        assertTrue(user.getTaskList().contains(task1));
        assertTrue(user.getTaskList().contains(task2));
    }

    @Test
    public void testRemoveTask() {
        assertTrue(user.getTaskList().contains(task1));
        assertTrue(user.getTaskList().contains(task2));
        user.removeTask(task1);
        assertFalse(user.getTaskList().contains(task1));
        assertTrue(user.getTaskList().contains(task2));
        user.removeTask(task1);
        assertEquals("Task does not exist", outputStreamCaptor.toString().trim());
    }

    @Test
    public void testTaskExists() {
        assertTrue(user.taskExists(task1));
        assertTrue(user.taskExists(task2));
        Task task3 = new Task("Task 3", LocalDate.of(2025, 12, 10));;
        assertFalse(user.taskExists(task3));
    }

    @Test
    public void testGetTaskList() {
        assertEquals(2, user.getTaskList().size());
        assertEquals("Task 1", user.getTaskList().get(0).getTitle());
        assertEquals("Task 2", user.getTaskList().get(1).getTitle());
    }

    @Test
    public void testGetNotification() {
        String message = "You have a new task!";
        user.getNotification(message);
        assertEquals(message, outputStreamCaptor.toString().trim());
    }
}
