/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paper3.exercise2.socket.webserver;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Florian
 */
public class ServerResponse implements Runnable
{

    private Socket socket;
    private String name;

    public ServerResponse(Socket socket, int i)
    {
        this.socket = socket;
        this.name = "Thread: " + String.valueOf(i);
    }

    @Override
    public void run()
    {
        try (
                InputStream in = socket.getInputStream();
                OutputStream out = socket.getOutputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                PrintWriter writer = new PrintWriter(out);)
        {

            String str = reader.readLine();
            Path p = Paths.get(str.split(" ")[1].substring(1));
            List<String> zeilen = Files.readAllLines(p, Charset.defaultCharset());

            String doc = "HTTP/1.1 200 OK\r\nContent-Type: text/html\r\nContent-Length: ";
            String temp = "";

            temp = zeilen.stream().map((string) -> string).reduce(temp, String::concat);

            doc += String.valueOf(temp.length()) + "\r\n\r\n";
            doc += temp;

            System.out.println(doc);
            writer.print(doc);
        } catch (IOException ex)
        {
            Logger.getLogger(Paper3Exercise2SocketWebserver.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(this.name + " sleeping");
        
        try
        {
            Thread.sleep(10000);
        } catch (InterruptedException ex)
        {
            Logger.getLogger(ServerResponse.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(this.name + " done");
        try
        {
            socket.close();
        } catch (IOException ex)
        {
            Logger.getLogger(ServerResponse.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
