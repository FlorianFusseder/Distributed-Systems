/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paper3.exercise1.sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Florian
 */
public class Paper3Exercise1SocketsClient
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        System.out.println("Client");
        InetAddress addr = null;
        
        try
        {
            //addr = InetAddress.getByName("88.133.180.69");
            //addr = InetAddress.getByName("192.168.178.39");
            addr = InetAddress.getLocalHost();
        } catch (UnknownHostException ex)
        {
            Logger.getLogger(Paper3Exercise1SocketsClient.class.getName()).log(Level.SEVERE, null, ex);
        }

        try (                
                Socket s = new Socket(addr, 8080);
                InputStream in = s.getInputStream();
                OutputStream out = s.getOutputStream();
                PrintWriter writer = new PrintWriter(out);
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));)
        {

            String message = null;

            do
            {
                message = reader.readLine();
            } while (message == null);

            System.out.println("Ich habe bekommen: " + message);
            String neueMessage = "*" + message + "*";
            System.out.println("Ich werde senden: " + neueMessage);
            writer.println(neueMessage);
            writer.flush();

        } catch (IOException ex)
        {
            Logger.getLogger(Paper3Exercise1SocketsClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
