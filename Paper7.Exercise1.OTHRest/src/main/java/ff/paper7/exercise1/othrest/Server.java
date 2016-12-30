/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ff.paper7.exercise1.othrest;

import Rest.StudentService;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import javax.swing.JOptionPane;
import javax.ws.rs.ext.RuntimeDelegate;
import org.glassfish.jersey.server.ResourceConfig;

/**
 *
 * @author Florian
 */
public class Server {

	public static void main(String[] args) throws IOException {

		Persistence.build();

		HttpServer webserver = HttpServer.create(new InetSocketAddress(8080), 0);

		ResourceConfig config = new ResourceConfig();
		config.register(StudentService.class);

		HttpHandler handler = RuntimeDelegate.getInstance().createEndpoint(config, HttpHandler.class);
		webserver.createContext("/othrest", handler);
		webserver.start();

		JOptionPane.showMessageDialog(null, "Server started");

	}
}
