package com.example.demo.repository;

import com.example.demo.model.Message;

import java.util.List;

public interface MessageRepository {
    public List<Message> getAllMessage();
    public void newMessage(Message m);
    public void deleteMessage(int id);
    public void editMessage(int id,Message m);
}
