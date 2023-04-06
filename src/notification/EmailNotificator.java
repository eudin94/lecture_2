package notification;

public class EmailNotificator {

    public static void sendSuccessNotification() {
        System.out.println("Client activated successfully!");
    }

    public static void sendFailureNotification() {
        System.out.println("Client already activated!");
    }
}
