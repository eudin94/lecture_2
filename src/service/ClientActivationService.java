package service;

import model.Client;

import static notification.EmailNotificator.sendFailureNotification;
import static notification.EmailNotificator.sendSuccessNotification;

public class ClientActivationService {

    public static void activate(Client client) {
        if (client.getActive()) {
            sendFailureNotification();
            return;
        }
        client.setActive(true);
        sendSuccessNotification();
    }
}
