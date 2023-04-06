package notification;

import model.Client;

public class TextNotificator {

    public static void sendTextNotification(Client client) {

        System.out.printf("Notifying (%s) by text through number (%s)", client.getName(), client.getPhone());

    }
}
