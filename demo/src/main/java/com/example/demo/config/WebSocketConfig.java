package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.example.demo.handler.ChatHandler;


@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

	  @Autowired
	    private ChatHandler chatHandler;

	    @Override
	    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
	        // 해당 endpoint로 handshake가 이루어진다.
	        registry.addHandler(chatHandler, "/chat2/{roomNumber}").setAllowedOrigins("*");;
	    }
}