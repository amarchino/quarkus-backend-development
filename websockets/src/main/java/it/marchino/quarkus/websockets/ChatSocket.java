package it.marchino.quarkus.websockets;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;

import javax.enterprise.context.ApplicationScoped;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.jboss.logmanager.Logger;

@ServerEndpoint("/chat/{username}")
@ApplicationScoped
public class ChatSocket {

	private final Logger LOG = Logger.getLogger(ChatSocket.class.getName());
	private final ConcurrentMap<String, Session> sessionMap = new ConcurrentHashMap<>();

	@OnOpen
	public void onOpen(Session session, @PathParam("username") String username) {
		LOG.info("onOpen> " + username);
		sessionMap.put(username, session);
		sendMessage(String.format("User %s logged in", username));
	}

	@OnClose
	public void onClose(Session session, @PathParam("username") String username) {
		LOG.info("onClose> " + username);
		sessionMap.remove(username);
		sendMessage(String.format("User %s logged out", username));
	}

	@OnError
	public void onError(Session session, @PathParam("username") String username, Throwable throwable) {
		LOG.log(Level.SEVERE, "onError> " + username + ": " + throwable, throwable);
		sessionMap.remove(username);
		sendMessage(String.format("User %s logged out because of an error", username));
	}

	@OnMessage
	public void onMessage(String message, @PathParam("username") String username) {
		LOG.info("onMessage> " + username + ": " + message);
		sendMessage(String.format(">> %s: %s", username, message));
	}

	private void sendMessage(String message) {
		sessionMap.values().forEach(it -> it.getAsyncRemote().sendObject(message, sendResult -> {
			if(sendResult.getException() != null) {
				LOG.log(Level.SEVERE, "exception", sendResult.getException());
			}
		}));
	}
}
