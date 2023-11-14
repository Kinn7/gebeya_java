public class CustomExceptionHandler {

    public static void handleChatException(ChatException e) {
        // Handle your chat related exceptions here
        // For example, you could log it to the console or show a message to the user
        System.out.println(e.getMessage());
    }
}

public class ChatException extends Exception {
    public ChatException(String message) {
        super(message);
    }
}