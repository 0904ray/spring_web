package com.example.demo.service.implement;

import com.example.demo.dto.MessageDto;
import com.example.demo.mapper.MessageMapper;
import com.example.demo.model.Message;
import com.example.demo.repository.MessageRepository;
import com.example.demo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MessageServiceImpl implements MessageService {
    private final MessageRepository messageRepository;

    @Autowired
    public MessageServiceImpl(MessageRepository messageRepository){
        this.messageRepository = messageRepository;
    }

    @Override
    public List<MessageDto> getAllMessages(){
        List<Message> messages = messageRepository.getAllMessage();
        List<MessageDto> messageDtos = new ArrayList<>();
        for(Message message : messages){
            messageDtos.add(MessageMapper.mapToDto(message));
        }
        return messageDtos;
    }
}
