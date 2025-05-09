package org.example;

import java.util.ArrayList;
import java.util.List;

public class NotificationService {
    User user;
    List<User> userList;

    public NotificationService(User user) {
        this.user = user;
        this.userList = new ArrayList<>();
        userList.add(user);
    }

    /**
     * Sends a notification message to the user
     * @param message the notification message to send to the user
     * @effects invokes the getNotification method of the user to display the message
     */

    public void notifyUser(String message) {
        user.getNotification(message);
    }
}
