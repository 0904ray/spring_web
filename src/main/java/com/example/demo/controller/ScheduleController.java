package com.example.demo.controller;

import com.example.demo.model.Message;
import com.example.demo.service.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ScheduleController {

    private final MessageService messageService;

    public ScheduleController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public String home(Model model){
        List<Message> messages = messageService.getAllMessages();
        model.addAttribute("messages", messages);
        return "home";
    }
}
