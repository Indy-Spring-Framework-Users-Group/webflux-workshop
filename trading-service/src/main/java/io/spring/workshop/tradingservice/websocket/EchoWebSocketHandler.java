package io.spring.workshop.tradingservice.websocket;

import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Mono;

import java.time.Duration;

public class EchoWebSocketHandler implements WebSocketHandler {

    @Override
    public Mono<Void> handle(WebSocketSession session) {
        return session.send(session.receive().delayElements(Duration.ofSeconds(1)).log());
    }
}
