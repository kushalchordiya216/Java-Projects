import java.net.*;
import java.io.*;

class MyClient {
    private String hostname;
    private int port;

    public MyClient(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
    }

    public void execute() {
        Socket s;
        try {
            s = new Socket(hostname, port);
            WriteThread write = new WriteThread(s);
            ReadThread read = new ReadThread(s);
            write.start();
            read.start();
        }catch (UnknownHostException ex) {
            System.out.println("Server not found: " + ex.getMessage());
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        if (args.length < 2) return;
 
        String hostname = args[0];
        int port = Integer.parseInt(args[1]);
 
        MyClient client = new MyClient(hostname, port);
        client.execute();
    }
}  