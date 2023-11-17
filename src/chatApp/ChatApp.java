package chatApp;

import exceptions.ChatException;
import exceptions.CustomExceptionHandler;
import exceptions.InvalidKeyException;
import exceptions.SystemExceptionHandler;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The ChatApp class provides a text-based user interface for interacting with public chats,
 * private chats, and a friends list. It offers options to read, write, view, and add through
 * a menu-driven system.
 */
public class ChatApp {
    /**
     * Runs the main chat application loop and handles user input for menu selection.
     */
    public void run(){
        PublicChat publicChat = new PublicChat();
        PrivateChat privateChat = new PrivateChat();
        FriendsList friendsList = new FriendsList();

        // Check if the necessary objects are created properly
        try {
            if( publicChat == null || privateChat == null || friendsList == null)
                throw new NullPointerException("System cannot create necessary objects.");
        } catch(Exception e) {
            SystemExceptionHandler.logException(e);
        }

        Scanner input = new Scanner(System.in);

        // Main loop for the application menu
        try {
            while (true) {
                System.out.println("""
                        Press 1 To read/write public chat
                        Press 2 To read/write private chat
                        Press 3 to view/add friends.
                        Enter 4 to exit program
                        """);

                System.out.print("Choice: ");
                String choice;

                // Get user menu choice
                try {
                    choice = input.nextLine();
                } catch (InputMismatchException e) {
                    CustomExceptionHandler.handleInvalidInput(e);
                    continue;
                }

                // Process the choice
                switch (choice) {
                    case "1":
                        publicChat.userMenuForPublicChat();
                        break;
                    case "2":
                        privateChat.userMenuForPrivateChat();
                        break;
                    case "3":
                        friendsList.userMenuForFriendsList();
                        break;
                    case "4":
                        System.out.println("Exited prompt");
                        System.exit(0);
                        break;
                    default:
                        throw new InvalidKeyException("Invalid key pressed: " + choice);
                }
            }
        } catch (InvalidKeyException e) {
            // Handle invalid key pressed
            CustomExceptionHandler.handleInvalidKeyException(e);
        } catch (Exception e) {
            // Log other exceptions
            SystemExceptionHandler.logException(e);
        } finally {
            input.close(); // Close the scanner
        }
    }
}
