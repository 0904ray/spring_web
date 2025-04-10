package com.example.demo.mapper;

import com.example.demo.dto.MessageDto;
import com.example.demo.model.Message;



public class MessageMapper {
    public static Message mapToMessage(MessageDto dto){
        return Message.builder()
                .id(dto.getId())
                .message(dto.getMessage())
                .time(dto.getDate()+dto.getHour())
                .notified(dto.isNotified())
                .build();
    }
    public static MessageDto mapToDto(Message message){
        return MessageDto.builder()
                .id(message.getId())
                .message(message.getMessage())
                .date(message.getTime().substring(0,8))
                .hour(message.getTime().substring(8))
                .notified(message.isNotified())
                .build();
    }
}
