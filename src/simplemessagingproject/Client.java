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
    
   // private int port;
    
    private SimpleDateFormat sdf;
    
    
    
    public static void main(String args[])throws IOException{
        int port = 1500;
        String host = "localhost";
        System.out.println("Creating socket to '" + host + "' on port " + port);
        Socket Socket = new Socket(host, port);
    }
}
