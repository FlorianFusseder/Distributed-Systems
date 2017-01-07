/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.fusseder.paper8.exercise1.othrestdb;

import Services.PruefungsleistungsService;
import Services.StudentenService;
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
public class main {
	
	public static void main(String[] args) throws IOException {

		HttpServer httpServer = HttpServer.create(new InetSocketAddress(8080), 0);
		
		ResourceConfig resourceConfig = new ResourceConfig();
		resourceConfig.register(StudentenService.class);
		resourceConfig.register(PruefungsleistungsService.class);
		
		HttpHandler httpHandler = RuntimeDelegate.getInstance().createEndpoint(resourceConfig, HttpHandler.class);
		httpServer.createContext("/fh", httpHandler);
		
		httpServer.start();
		
		JOptionPane.showMessageDialog(null, "Stop Server");
		httpServer.stop(0);
	}
	
}
