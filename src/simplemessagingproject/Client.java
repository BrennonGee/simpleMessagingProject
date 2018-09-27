package simplemessagingproject;

import java.net.ServerSocket;
import java.text.SimpleDateFormat;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author Brennon
 */
public class Client {
    
    private int port;
    
    private String host;
    
    private SimpleDateFormat sdf;
    
    private boolean keepRunning;
    
    private void Client (int port, String host){
        this.port = 1500;
        this.host = "localhost";
    }
    
    public void run(){
        System.out.println("Creating socket to '" + host + "' on port " + port);
        try {
            
            while (keepRunning){

                Socket Socket = new Socket(host, port);
                

            } 
        }
        catch (IOException e){
            
        }
    }
    
    
    public static void main(String args[]){
        int port = 2;
        String host = "localhost";
               
        Client client = new Client();
        client.run();
        
    }
}
