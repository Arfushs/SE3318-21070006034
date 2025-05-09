package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class TaskManagerTest {

    private User user;
    private TaskManager taskManager;
    private Task task1;
    private Task task2;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        user = new User("James Hetfield", "james.hetfield@metallica.com");
        taskManager = new TaskManager();
        task1 = new Task("Task 1", LocalDate.of(2025, 5, 10));
        task2 = new Task("Task 2", LocalDate.of(2025, 8, 10));
        user.assignTask(task1);
        user.assignTask(task2);
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void testRemoveTask() {
        assertTrue(user.getTaskList().contains(task1));
        assertTrue(user.getTaskList().contains(task2));
        taskManager.removeTask(user, task1);
        assertFalse(user.getTaskList().contains(task1));
        assertTrue(user.getTaskList().contains(task2));
    }

    @Test
    public void testListTasks() {
        taskManager.listTasks(user);
        String expectedOutput = "1-Task 1" + System.lineSeparator() + "2-Task 2" + System.lineSeparator();
        assertEquals(expectedOutput, outputStreamCaptor.toString());
    }
}
