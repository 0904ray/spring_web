package com.example.demo.controller;

import com.example.demo.dto.MessageDto;
import com.example.demo.service.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ScheduleController {

    private final MessageService messageService;

    public ScheduleController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public String home(Model model){
        List<MessageDto> messages = messageService.getUnnotifiedMessages();
        model.addAttribute("messages", messages);
        return "home";
    }

    @PostMapping("/new_sch")
    public String newSchedule(Model model, @ModelAttribute MessageDto messageDto){
        if(messageDto.getHour().length()==1){
            messageDto.setHour(String.format("%02d", Integer.parseInt(messageDto.getHour())));
        }
        messageService.newMessage(messageDto);
        List<MessageDto> messages = messageService.getUnnotifiedMessages();
        model.addAttribute("messages", messages);
        return "home";
    }

    @PostMapping("/modify_sch")
    public String modifySchedule(Model model, @ModelAttribute MessageDto messageDto){
        if(messageDto.getHour().length()==1){
            messageDto.setHour(String.format("%02d", Integer.parseInt(messageDto.getHour())));
        }
        messageService.modifyMessage(messageDto);
        List<MessageDto> messages = messageService.getUnnotifiedMessages();
        model.addAttribute("messages", messages);
        return "home";
    }

    @PostMapping("/delete_sch")
    public String deleteSchedule(Model model, @RequestParam int id){
        messageService.deletMessage(id);
        List<MessageDto> messages = messageService.getUnnotifiedMessages();
        model.addAttribute("messages", messages);
        return "home";
    }
}
