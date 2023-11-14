import java.util.Scanner;

public class ChatApp {
    public void run(){

        try{
            PublicChat publicChat = new PublicChat();
            PrivateChat privateChat = new PrivateChat();
            FriendsList friendsList = new FriendsList();

            Scanner input = new Scanner(System.in);

            while (true) {
                System.out.println(""" 
                        Press 1 To read/write public chat
                        Press 2 To read/write private chat
                        Press 3 view/add friends.
                        Enter 4 to exit program
                        """);

                System.out.print("Choice: ");

                String choice = input.nextLine();

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
                        System.out.println("Invalid key pressed");
                        break;
                }
            }catch (ChatException e) {
                CustomExceptionHandler.handleChatException(e);
            } catch (Exception e) {
                SystemExceptionHandler.logException(e);
            }
        }
    }
}
