/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.fusseder.paper5.exercise0.Services;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import javax.swing.JOptionPane;
import javax.ws.rs.ext.RuntimeDelegate;
import org.glassfish.jersey.server.ResourceConfig;

/**
 *
 * @author Florian Fußeder
 */
public class Server {
	public static void main(String[] args) throws IOException {
		HttpServer webserver = HttpServer.create(new InetSocketAddress(8080), 0);
		
		ResourceConfig config = new ResourceConfig();
		config.register(GeschenkeService.class);
		
		HttpHandler handler = RuntimeDelegate.getInstance().createEndpoint(config, HttpHandler.class);
		webserver.createContext("/webapi", handler);
		webserver.start();
		
	}	
}
