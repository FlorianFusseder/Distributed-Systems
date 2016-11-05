/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paper3.exercise1.sockets.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Florian
 */
public class Paper3Exercise1SocketsServer
{

    public static int read()
    {
        System.out.println("Server\neingabe:");
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        int port = read();
        System.out.println("thx brah");

        try (ServerSocket servSocket = new ServerSocket(port))
        {
            try (
                    Socket s = servSocket.accept();
                    InputStream in = s.getInputStream();
                    OutputStream out = s.getOutputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                    PrintWriter writer = new PrintWriter(out);)
            {

                String send = "Hello World";
                System.out.println("Ich werde senden: " + send);
                writer.println(send);
                writer.flush();

                String antwort = null;
                do
                {
                    antwort = reader.readLine();
                } while (antwort == null);

                System.out.println("Ich habe bekommen:  " + antwort);

            } catch (IOException ex)
            {
                Logger.getLogger(Paper3Exercise1SocketsServer.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (IOException ex)
        {
            Logger.getLogger(Paper3Exercise1SocketsServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
