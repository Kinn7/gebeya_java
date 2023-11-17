
package exceptions;

import java.util.InputMismatchException;

public class CustomExceptionHandler {

    public static void handleChatException(ChatException e) {
        // Handle your chat related exceptions here
        // For example, you could log it to the console or show a message to the user
        System.out.println(e.getMessage());
    }
    public static void handleInvalidKeyException(InvalidKeyException e){
        System.out.println(e.getMessage());
    }
    public static void handleInvalidInput(InputMismatchException e){
        System.out.println(e.getMessage());
    }
    public static void handleFileReadException(FileReadException e){
        System.out.println(e.getMessage());
        // Additional handling could go here
    }

    public static void handleFileWriteException(FileWriteException e){
        System.out.println(e.getMessage());
        // Additional handling could go here
    }
}

