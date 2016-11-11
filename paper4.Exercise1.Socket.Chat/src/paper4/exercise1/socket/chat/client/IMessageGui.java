package paper4.exercise1.socket.chat.client;

public interface IMessageGui {
	public void showNewMessage(String fromUser, String message);
	public void showAdminMessage(String message);
}
