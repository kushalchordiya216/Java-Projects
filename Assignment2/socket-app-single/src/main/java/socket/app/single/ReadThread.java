import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * ReadThread
 */
public class ReadThread extends Thread {
    private BufferedReader reader;
    private Socket socket;
    public ReadThread(Socket socket) {
        this.socket = socket;
        InputStream input;
        try {
            input = socket.getInputStream();
            reader = new BufferedReader(new InputStreamReader(input));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run(){
        while(true){
            try{
                String response = reader.readLine();
                System.out.println("\n" + response);
            }catch(IOException ex){
                System.out.println("Error reading from server: "+ ex.getMessage());
                ex.printStackTrace();
                break;
            }
        }
    }
}