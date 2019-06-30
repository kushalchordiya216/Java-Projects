import java.io.Console;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * WriteThread
 */
public class WriteThread extends Thread {
    private PrintWriter writer;
    private Socket socket;
    
    public WriteThread(Socket socket) {
        this.socket = socket;
        try {
            OutputStream output = socket.getOutputStream();
            writer = new PrintWriter(output,true); 
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public void run() {
        Console console = System.console();
        
        String text;
        do{
            text = console.readLine();
            writer.println(">" + text);
        }while(!text.equals("bye"));
        
        try {
            socket.close();
        } catch (IOException ex) {
 
            System.out.println("Error writing to server: " + ex.getMessage());
        }
    }
}