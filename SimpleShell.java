
import java.io.*;

public class SimpleShell {
        public static void main(String[] args) {
            System.out.println(System.getProperty("user.dir"));
            boolean stop = false;
            while (!stop)
                stop = menu();
            }
// read what the user entered


/**
 * The steps are:
 (1) parse the input to obtain the command and any parameters
 (2) create a ProcessBuilder object
 (3) start the process
 (4) obtain the output stream
 (5) output the contents returned by the command
 */
public static boolean menu() {
            try{
                String commandLine;
                BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
                System.out.print("mysh>");
                commandLine = console.readLine();
                String[] str;
                Process process;
// if the user entered a return, just loop again
                if (commandLine.isEmpty())
                    return false;
                else if (commandLine.equalsIgnoreCase("exit"))
                    return true;
                else if (commandLine.contains(" ")) {
                    str = commandLine.split(" ", 2);
                    process = new ProcessBuilder(str[0], str[1]).start();
                    System.out.println(process);
                    return false;
                } else {
                    process = new ProcessBuilder(commandLine).start();
                    System.out.println(process);
                    return false;
                }
            }catch (IOException e) {
                System.out.println("Incorrect input");
                return false;
           }
      }
}