package paper4.exercise1.socket.chat.server;

public interface IChatMessageHub {
	public void addChatListener(IChatListener listener);
	public void removeChatListener(IChatListener listener);
	public void publish(String fromUser, String message, boolean isAdmin);
}
