import model.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.System.in;

public class Main {

    public static Scanner sc = new Scanner(in);
    public static List<Client> clients = new ArrayList<>();

    public static void main(String[] args) {
        printMainMenu();

    }

    public static void printMainMenu() {
        System.out.println(
                """
                        ############################################
                        1. Register client
                        2. List clients
                        ############################################
                        - Type one of the options:\s
                        """
        );
        mainMenu();
    }

    public static void mainMenu() {
        var option = sc.nextInt();
        if (option == 1) {
            registerClient();
        } else if (option == 2) {
            listClients();
        } else {
            System.out.println("Invalid option!");
            printMainMenu();
        }
    }

    public static void registerClient() {
        System.out.println("Type client name: ");
        final var name = sc.next();

        System.out.println("Type client email: ");
        final var email = sc.next();

        System.out.println("Type client phone: ");
        final var phone = sc.next();

        clients.add(new Client(name, email, phone, false));
        System.out.println("Client registered!");
        printMainMenu();
    }

    public static void listClients() {
        var counter = new AtomicInteger(1);
        clients.forEach(client -> {
            System.out.println(
                    counter.get() + "- " + client
            );
            counter.set(counter.get() + 1);
        });
    }
}
