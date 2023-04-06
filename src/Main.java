import model.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.System.in;
import static service.ClientActivationService.activate;

public class Main {

    public static BufferedReader reader = new BufferedReader(new InputStreamReader(in));
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
                        3. Exit Program
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
            case 3 -> System.exit(0);
            default -> System.out.println("\nInvalid option!");
        }
        runMainMenu();
    }

    private static void registerClient() {
        System.out.print("\nType client name: ");
        var name = scanLine();

        System.out.print("\nType client email: ");
        var email = scanLine();

        System.out.print("\nType client phone: ");
        var phone = scanLine();

        clients.add(new Client(name, email, phone, false));
        System.out.println("\nClient registered!");
    }

    private static void listClients() {
        if (clients.isEmpty()) {
            System.out.println("\nNo clients to list!");
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
        var input = scanInt();

        if (input == 0) return;

        if (clients.size() < input) {
            System.out.println("\nInvalid option!");
            listClients();
            return;
        }

        var index = input - 1;
        var client = clients.get(index);

        activate(client);
    }

    private static int scanInt() {
        try {
            return Integer.parseInt(reader.readLine());
        } catch (IOException | NumberFormatException e) {
            System.out.print("\nInvalid input! Try again: ");
            return scanInt();
        }
    }

    private static String scanLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            System.out.print("\nInvalid input! Try again: ");
            return scanLine();
        }
    }
}
