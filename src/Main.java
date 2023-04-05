import model.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.System.in;
import static java.util.Objects.isNull;

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
        var input = scanInt();

        switch (input) {
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
        if (clients.isEmpty()) {
            System.out.println("No clients to list!");
            return;
        }

        var counter = new AtomicInteger(1);
        clients.forEach(client -> {
            System.out.println(
                    counter.get() + "- " + client
            );
            counter.set(counter.get() + 1);
        });
        inputClientList();
    }

    private static void inputClientList() {
        System.out.print("Type the client number to activate, or zero to return: ");
        final var input = scanInt();

        if (input == 0) return;
        final var index = input - 1;
        final var client = clients.get(index);

        if (isNull(client)) {
            System.out.println("Invalid option!");
            listClients();
        } else if (client.getActive()) {
            System.out.println("Client already activated!");
        }

        System.out.println("Client " + client.getName() + " activated!");
        client.setActive(true);
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
