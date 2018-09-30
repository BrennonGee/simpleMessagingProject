package simplemessagingproject;

import java.text.SimpleDateFormat;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Brennon
 */
public class Client {
    
    private int port;
    
    private String host;
    
    private String username;
    
    private SimpleDateFormat sdf;
    
    private boolean keepRunning;
    
    private ObjectInputStream sInput;
    
    private ObjectOutputStream sOutput;
    
    private Socket socket;

    
    Client (int port, String username, String host){
        this.username = username;
        this.port = port;
        this.host = host;
    }
    
    public boolean run(){
        System.out.println("Creating socket to '" + host + "' on port " + port);
        try {
            Socket Socket = new Socket(host, port);
        }
        catch (IOException e){
            close();
            return false;
        }
        
        try
        {
            sInput  = new ObjectInputStream(socket.getInputStream());
            sOutput = new ObjectOutputStream(socket.getOutputStream());
        }

        catch (IOException eIO) {
            System.out.println("Exception creating new Input/output Streams: " + eIO);
            return false;
        }

        
        return true;
    }
    
    public void close(){
        try {
            if(sInput != null) sInput.close();
        }
        catch(IOException e) {} 
        try {
            if(sOutput != null) sOutput.close();
        }
        catch(IOException e) {} 
        try{
            if(socket != null) socket.close();
        }
        catch(IOException e) {} 
    }
    
    public void send(String msg){
        try {
            sOutput.writeObject(msg);
        }
        catch(IOException e) {
            System.out.println("Exception writing to server: " + e);
        }

    }
    
    
    public static void main(String args[]){
        if (args.length > 2 || args.length < 3){
            System.out.println("Not enough arguments");
            System.out.println("Usage: Client [port] [server address] [username] ");
        }
        
        int cPort = Integer.parseInt(args[1]);
        String sHost = args[2];
        String cUsername = args[3];
        
        Client client = new Client(cPort, sHost, cUsername);
        if (!client.run()){
            System.out.println("Could not connect to the server ");
            return;
        }
        
        Scanner in = new Scanner(System.in);
        
        while (true){
            System.out.print("> ");
            String message = in.nextLine();
            
            if(message.equalsIgnoreCase("LOGOUT")){
                break;
            }
            else if (message.equalsIgnoreCase("HELP")){
                
            }
            else if (message.equalsIgnoreCase("USERS")){
                
            }
            else{
                client.send(message);
            }
            client.close();
        }
    }
}
