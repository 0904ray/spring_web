package com.example.demo.repository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;



import com.example.demo.model.Message;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class JSONRepository implements MessageRepository{
    private static final String FILE_PATH = "src/main/java/com/example/demo/repository/message.json";
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public List<Message> getAllMessage() {
        try{
            File file = new File(FILE_PATH);
            System.out.println(file.exists());
            if (!file.exists()) {
                return new ArrayList<>();
            }
            return objectMapper.readValue(file, new TypeReference<List<Message>>() {});
        }catch (IOException e){
            return new ArrayList<>();
        }

    }

    @Override
    public void newMessage(Message m) {

    }

    @Override
    public void deleteMessage(int id) {

    }

    @Override
    public void editMessage(int id, Message m) {

    }
}
