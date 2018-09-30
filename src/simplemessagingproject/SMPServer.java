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
        
        System.out.println("server is live");
        
        try {
            ServerSocket serverSocket = new ServerSocket(port);

            while(keepRunning){                
                Socket socket = serverSocket.accept();
                System.out.println("Connection made");
                
            }
        }
        catch(IOException e){
            //display("Exception closing the server and clients: " + e);
        }
        
        
    }
    
    
    
    
    
    
    
    public static void main(String[] args) {
        SMPServer server = new SMPServer (1500);
        server.run();
        
    }
    
    
        class ClientThread extends Thread {
        Socket socket;
        ObjectInputStream sInput;
        ObjectOutputStream sOutput;
        int id;
        String username;
        String time;
     
        ClientThread (Socket socket){
            
            
        }
        
        
        public boolean outMsg(String msg){
            
            if (!socket.isConnected()){
                System.out.println("Connection no loger exists ");
                return false;
            }
            
            try{
                sOutput.writeObject(msg);
                
            }
            catch(IOException e){
                System.out.println("Error sending message to " + username);
            }
            
            return true;
        }
    }
}
