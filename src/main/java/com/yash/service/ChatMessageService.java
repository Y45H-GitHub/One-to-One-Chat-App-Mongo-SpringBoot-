package com.yash.service;

import com.yash.chat.ChatMessage;
import com.yash.repo.ChatMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatMessageService {
    /*

Let’s say:
senderId = "Alice"
recipientId = "Bob"

If Alice sends a message:
The system first tries to find a chat room between Alice and Bob.
If none exists, it creates one (because true is passed).
Then it sets the chatId and saves the message.

If Alice wants to see messages:
The system tries to find the chat room between Alice and Bob.
If the room is found, it fetches all messages from that chat.
If the room doesn’t exist, it returns an empty list.

 */

    private final ChatMessageRepository repository;
    private final ChatRoomService chatRoomService;

    public ChatMessage save(ChatMessage chatMessage){

        var chatId= chatRoomService.getChatRoomId(chatMessage.getSenderId(),
                chatMessage.getRecipientId(),
                true).orElseThrow(); // create own exception
        chatMessage.setChatId(chatId);
        repository.save(chatMessage);
        return chatMessage;
    }

    public List<ChatMessage> findChatMessages(String senderId, String recepientId){

        var chatId= chatRoomService.getChatRoomId(senderId, recepientId, false);
        return chatId.map(repository::findByChatId).orElse(new ArrayList<>());
    }
}
