/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ff.paper9.exercise1.datagrid;

import Entitys.Student;
import Services.PruefungsleistungsService;
import Services.StudentenService;
import Services.VeranstaltungService;
import com.hazelcast.config.Config;
import com.hazelcast.config.JoinConfig;
import com.hazelcast.config.NetworkConfig;
import com.hazelcast.config.ReplicatedMapConfig;
import com.hazelcast.config.SerializationConfig;
import com.hazelcast.config.SerializerConfig;
import com.hazelcast.config.XmlConfigBuilder;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.nio.serialization.ClassDefinition;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Arrays;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.ws.rs.ext.RuntimeDelegate;
import org.glassfish.jersey.server.ResourceConfig;

/**
 *
 * @author Florian Fußeder
 */
public class main {

	private static final Logger logger = Logger.getLogger(main.class.getName());

	public static HazelcastInstance hazelcast = null;

	public static void main(String[] args) throws IOException {

		HttpServer httpServer = HttpServer.create(new InetSocketAddress(8080), 0);

		ResourceConfig resourceConfig = new ResourceConfig();
		resourceConfig.register(StudentenService.class);
		resourceConfig.register(PruefungsleistungsService.class);
		resourceConfig.register(VeranstaltungService.class);
		HttpHandler httpHandler = RuntimeDelegate.getInstance().createEndpoint(resourceConfig, HttpHandler.class);
		httpServer.createContext("/fh", httpHandler);
		httpServer.start();

		logger.info("Server started");

		// Hazelcast-Instanz erzeugen:
		// Netzwerk-Configuration erstellen
		Config hazelcastConfig = new Config();
		hazelcastConfig.getNetworkConfig().setPortAutoIncrement(true);
		NetworkConfig networkConfig = hazelcastConfig.getNetworkConfig();
		networkConfig.getInterfaces().setEnabled(false);

		// Setzen Sie dieses Interface auf den Adressbereich Ihres Netzwerks
		// Fuer die OTH bitte auf 172.*.*.* setzen
		networkConfig.getInterfaces().setInterfaces(Arrays.asList("172.*.*.*"));
		JoinConfig joinConfig = networkConfig.getJoin();
		joinConfig.getMulticastConfig().setEnabled(true);
		joinConfig.getMulticastConfig().setMulticastGroup("224.2.2.3");
		joinConfig.getMulticastConfig().setMulticastPort(54327);
		
		//Serialtion Config
		hazelcastConfig.getSerializationConfig().addPortableFactory(1, new MyPortableFactory());
		
		// Neue Hazelcast-Instanz erzeugen
		hazelcast = Hazelcast.newHazelcastInstance(hazelcastConfig);

		logger.info("Hazelcast startet");

		JOptionPane.showMessageDialog(null, "Server stoppen...");
		httpServer.stop(0);
		hazelcast.shutdown();
		logger.info("Shutdown successfull");

	}

}
