package com.example.demo.repository;

import com.example.demo.model.Message;

import java.util.List;

public interface MessageRepository {
    public List<Message> getAllMessage();
    public List<Message> getUnnotifiedMessage();
    public int getMessageCount();
    public void newMessage(Message m);
    public void deleteMessage(int id);
    public void modifyMessage(Message m);
}
