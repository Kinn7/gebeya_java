import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileReadWriteTemplate {

    public void writeToFile(String fileName,String input){
       // this.file = new File(fileName);
        try {
            PrintWriter write = new PrintWriter(new FileWriter(fileName,true));
            write.println(input);
            write.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void readFile(String fileName){
        try {
            File file = new File(fileName);
            Scanner read = new Scanner(file);
            while(read.hasNext()){
               System.out.println(read.nextLine());
            }
            read.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void prompt(String fileName) {
        Scanner input = new Scanner(System.in);
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
                    String textToWrite = input.nextLine();
                    writeToFile(fileName,textToWrite);
                    break;
                case "3":
                    break outerLoop;
                case "4":
                    System.out.print("Exited prompt");
                    input.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("key invalid");
                    break;
            }
        }
    }
}
