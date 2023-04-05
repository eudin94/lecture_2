import model.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.System.in;

public class Main {

    public static Scanner sc;
    public static List<Client> clients = new ArrayList<>();

    public static void main(String[] args) {
        runMainMenu();
    }

    private static void runMainMenu() {
        System.out.print(
                """
                        ############################################
                        1. Register client
                        2. List clients
                        ############################################
                        - Type one of the options:\s"""
        );
        inputMainMenu();
    }

    private static void inputMainMenu() {
        var option = scanInt();

        switch (option) {
            case 1 -> registerClient();
            case 2 -> listClients();
            default -> System.out.println("Invalid option!");
        }
        runMainMenu();
    }

    private static void registerClient() {
        System.out.print("\nType client name: ");
        final var name = scanLine();

        System.out.print("\nType client email: ");
        final var email = scanLine();

        System.out.print("\nType client phone: ");
        final var phone = scanLine();

        clients.add(new Client(name, email, phone, false));
        System.out.println("Client registered!");
    }

    private static void listClients() {
        var counter = new AtomicInteger(1);
        clients.forEach(client -> {
            System.out.println(
                    counter.get() + "- " + client
            );
            counter.set(counter.get() + 1);
        });
    }

    private static int scanInt() {
        cleanScanner();
        return sc.nextInt();
    }

    private static String scanLine() {
        cleanScanner();
        return sc.nextLine();
    }

    private static void cleanScanner() {
        sc = new Scanner(in);
    }
}
