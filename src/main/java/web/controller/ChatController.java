package web.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.List;
import java.util.Vector;

@Component
public class ChatController extends TextWebSocketHandler {

    // - 클라리언트 소켓들의 접속 명단을 저장하는 컬렉션 프레임워크 (리스트) // ArrayList(비동기) vs Vector(동기)
    private List<WebSocketSession> ClientList  = new Vector<>();

    // 1. 클라이언트가 서버 웹소켓에 접속 요청 했을 때
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("session = " + session);
        System.out.println("[서버 웹 소켓 측] JS 웹 소켓이 들어옴");
        ClientList.add(session); // 접속한 세션을 ClientList에 추가
        System.out.println("접속 인원" + ClientList.size());
    }

    // 2. 클라이언트가 서버 웹소켓에 접속 끊었을 때
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println("session = " + session);
        System.out.println("[서버 웹 소켓 측] JS 웹 소켓이 나감");
        ClientList.remove(session); // 접속 완료한 세션을 ClientList에서 제거
        System.out.println("접속 인원" + ClientList.size());

        // 퇴장 / 제거한 소켓(세션)을 제외한 다른 클라이언트 소켓(세션) 들에게 메시지 전송
        // 클라이언트 소켓의 정보를 세션에서 저장하고 있다.
        TextMessage textMessage = new TextMessage("Hello, ClientSocket");
        handleTextMessage(null, textMessage );
    }

    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        System.out.println("session = " + session + ", message = " + message);
        System.out.println(message.getPayload());

        //  특정한 세션으로 받은 메세지 내용을 현재 접속된 다른 세션에게도 전달
            // 1. 모든 접속된 클라이언트 소켓 하나씩 꺼내기
        for(int i = 0; i < ClientList.size(); i++) {
            WebSocketSession s = ClientList.get(i);
            s.sendMessage(message);
        }
    }
}
