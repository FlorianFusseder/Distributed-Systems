package paper4.exercise1.socket.chat.client;

import paper4.exercise1.socket.chat.client.IMessageGui;
import paper4.exercise1.socket.chat.client.IMessageSender;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientEndpoint extends Thread implements IMessageSender {

	// Vorschlag fuer Attribute, bitte erweitern oder aendern:
	private Socket socket;
	private BufferedReader reader;
	private PrintWriter writer;
	private IMessageGui messageGui;

	public ClientEndpoint() {
		
	}
	
	// Überschreiben Sie die Interface-Methoden und die run-Methode hier:

    @Override
    public void openChatConnection(String username, String host, int port, IMessageGui messageGui)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sendChatMessage(String message)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void closeChatConnection()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	
	
	
	
}
