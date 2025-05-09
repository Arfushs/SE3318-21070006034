package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

public class NotificationServiceTest {

    private User user;
    private NotificationService notificationService;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        user = new User("James Hetfield", "james.hetfield@metallica.com");
        notificationService = new NotificationService(user);
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void testNotifyUser() {
        String message = "You have a new task assigned!";
        notificationService.notifyUser(message);
        assertEquals(message + System.lineSeparator(), outputStreamCaptor.toString());
    }
}
