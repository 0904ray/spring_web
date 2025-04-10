package com.example.demo.service;

import com.example.demo.dto.MessageDto;

import java.util.List;


public interface MessageService {
    List<MessageDto> getAllMessages();
}
