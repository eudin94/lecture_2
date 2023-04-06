package service;

import model.Client;

import static notification.EmailNotificator.sendFailureNotification;
import static notification.EmailNotificator.sendSuccessNotification;
import static notification.TextNotificator.sendTextNotification;

public class ClientActivationService {

    public static void activate(Client client) {
        if (client.getActive()) {
            sendFailureNotification();
            return;
        }
        client.setActive(true);
        sendSuccessNotification();
        sendTextNotification(client);
    }
}
