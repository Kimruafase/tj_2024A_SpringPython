package web.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class ChatController extends TextWebSocketHandler {

    // 1. 클라이언트가 서버 웹소켓에 접속 요청 했을 때
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("session = " + session);
        System.out.println("[서버 웹 소켓 측] JS 웹 소켓이 들어옴");
    }

    // 2. 클라이언트가 서버 웹소켓에 접속 끊었을 때
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println("session = " + session);
        System.out.println("[서버 웹 소켓 측] JS 웹 소켓이 나감");
    }
}
