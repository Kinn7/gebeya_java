package chatApp;

import exceptions.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * This class provides template methods to read from and write to a file, as well as
 * a command-line prompt to interact with the file.
 */
public class FileReadWriteTemplate {

    /**
     * Writes the provided input to a file.
     *
     * @param fileName The name of the file to write to.
     * @param input    The input text to write to the file.
     * @throws FileWriteException If an I/O error occurs during writing to the file.
     */
    public void writeToFile(String fileName, String input) throws FileWriteException {
        try {
            PrintWriter write = new PrintWriter(new FileWriter(fileName, true));
            write.println(input);
            write.close();
        } catch (IOException e) {
            SystemExceptionHandler.logException(e);
            throw new FileWriteException("Error writing to file: " + fileName, e);
        }
    }

    /**
     * Reads the content from a file and prints it to the console.
     *
     * @param fileName The name of the file to read from.
     * @throws FileReadException If an I/O error occurs during reading from the file.
     */
    public void readFile(String fileName) throws FileReadException {
        try {
            File file = new File(fileName);
            Scanner read = new Scanner(file);
            while (read.hasNext()) {
                System.out.println(read.nextLine());
            }
            read.close();
        } catch (IOException e) {
            SystemExceptionHandler.logException(e);
            throw new FileReadException("Error reading from file: " + fileName, e);
        }
    }

    /**
     * Provides a command-line interface to interact with file operations.
     * Users can choose to read from a file, write to a file, return to the menu, or exit the program.
     *
     * @param fileName The name of the file to be read from or written to.
     */
    public void prompt(String fileName) {
        try (Scanner input = new Scanner(System.in)) {
            outerLoop:
            while (true) {
                System.out.println("Enter 1 to read messages from " + fileName);
                System.out.println("Enter 2 to write messages to " + fileName);
                System.out.println("Enter 3 to go to menu");
                System.out.println("Enter 4 to exit program");
                System.out.print("Choice: ");
                String choice = input.nextLine();
                switch (choice) {
                    case "1":
                        readFile(fileName);
                        break;
                    case "2":
                        System.out.print("Enter your message: ");
                        String textToWrite = input.nextLine();
                        writeToFile(fileName, textToWrite);
                        break;
                    case "3":
                        break outerLoop;
                    case "4":
                        System.out.print("Exited prompt");
                        System.exit(0);
                        break;
                    default:
                        CustomExceptionHandler.handleInvalidKeyException(new InvalidKeyException("Invalid key pressed"));
                        break;
                }
            }
        } catch (InputMismatchException e) {
            CustomExceptionHandler.handleInvalidInput(e);
        } catch (FileWriteException e) {
            CustomExceptionHandler.handleFileWriteException(e);
        } catch (FileReadException e) {
            CustomExceptionHandler.handleFileReadException(e);
        }
    }
}
