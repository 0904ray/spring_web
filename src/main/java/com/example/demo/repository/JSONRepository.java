package com.example.demo.repository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;



import com.example.demo.model.Message;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.lang.module.FindException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class JSONRepository implements MessageRepository{
    private static final String FILE_PATH = "src/main/java/com/example/demo/repository/message.json";
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public List<Message> getAllMessage() {
        try{
            File file = new File(FILE_PATH);
            return objectMapper.readValue(file, new TypeReference<List<Message>>() {});
        }catch (IOException e){
            System.out.println("can't find .json!");
            return new ArrayList<>();
        }
    }

    @Override
    public List<Message> getUnnotifiedMessage() {
        return getAllMessage().stream().filter(message -> !message.isNotified()).collect(Collectors.toList());
    }

    @Override
    public void newMessage(Message m) {
        List<Message> messages = getAllMessage();
        messages.add(m);
        saveAllMessages(messages);
    }

    @Override
    public void deleteMessage(int id) {
        List<Message> messages = getAllMessage();
        messages = messages.stream()
                .filter(msg -> msg.getId() != id)
                .collect(Collectors.toList());
        saveAllMessages(messages);
    }

    @Override
    public void modifyMessage(Message m) {
        List<Message> messages = getAllMessage();
        for (int i = 0; i < messages.size(); i++) {
            if (messages.get(i).getId() == m.getId()) {
                messages.set(i, m);
                break;
            }
        }
        saveAllMessages(messages);
    }
    @Override
    public int getMessageCount(){
        List<Message> messages = getAllMessage();
        return messages.size();
    }

    private void saveAllMessages(List<Message> messages){
        try {
            objectMapper.writeValue(new File(FILE_PATH), messages);
        }catch (IOException e){
            System.out.println("can't find .json!");
        }
    }
}
