package com.example.demo.service;

import com.example.demo.dto.MessageDto;

import java.util.List;


public interface MessageService {
    List<MessageDto> getUnnotifiedMessages();
    void newMessage(MessageDto m);
    void modifyMessage(MessageDto m);
    void deletMessage(int id);
}
