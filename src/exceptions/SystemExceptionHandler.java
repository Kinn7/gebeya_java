
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class SystemExceptionHandler {
    
    public static void logException(Exception e) {
        try (FileWriter fw = new FileWriter("system.log", true);
             PrintWriter pw = new PrintWriter(fw)) {
            e.printStackTrace(pw);
        } catch (IOException ioe) {
            // Handle any IOExceptions as well.
            ioe.printStackTrace();
        }
    }
}