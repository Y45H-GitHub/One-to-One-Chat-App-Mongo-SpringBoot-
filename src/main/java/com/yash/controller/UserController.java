package com.yash.controller;

import com.yash.service.UserService;
import com.yash.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    /*
    Because in the REST API (like GET /users), when you hit an endpoint, you always get a response back.
        But in WebSocket:You have to explicitly decide:
        Do I send a reply back? (using @SendToUser or messagingTemplate),
        Or do I just process silently?
     */

    @MessageMapping("/user.addUser")
    @SendToUser("/topic")
    public User addUser(@Payload User user){
        service.saveUser(user);
        return user;
    }

    @MessageMapping("/user.disconnectUser")
    @SendTo("/user/topic")
    public User disconnect(@Payload User user){
        service.disconnectUser(user);
        return user;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> findConnectedUsers(){
        return ResponseEntity.ok(service.findConnectedUsers());
    }

}
