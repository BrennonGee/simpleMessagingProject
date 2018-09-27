package simplemessagingproject;

import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author Brennon
 */
public class SMPServer {
    
    private int uniqueID;
    
    private int port;
    
    //private ArrayList<> al;
    
    private SimpleDateFormat sdf;
    
    private boolean keepRunning;
    
    
    
    public SMPServer(int port) {
        
        this.port = port;
        
        sdf = new SimpleDateFormat("HH:mm:ss");
        
        //al = new ArrayList<>();
    }
    
    public void run (){
        
        keepRunning = true;
        
        try {
            ServerSocket serverSocket = new ServerSocket(port);

            while(keepRunning){
                Socket socket = serverSocket.accept();
                System.out.println("server is live");
                
            }
        }
        catch(IOException e){
            //display("Exception closing the server and clients: " + e);
        }
        
        
    }
    
    
    
    
    
    
    
    public static void main(String[] args) {

        
    }
}
