/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paper3.exercise2.socket.webserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Florian
 */
public class Paper3Exercise2SocketWebserver
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        //ExecutorService es = Executors.newFixedThreadPool(50);
        ExecutorService es = Executors.newFixedThreadPool(4);
        int i = 1;

        try (ServerSocket servSocket = new ServerSocket(8080))
        {
            while (true)
            {
                Socket socket = servSocket.accept();
                es.execute(new ServerResponse(socket, i++));
            }
        } catch (IOException ex)
        {
            Logger.getLogger(Paper3Exercise2SocketWebserver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
