package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessageDto {
    private String id;
    private String message;
    private String date;
    private String hour;
    private boolean notified;

}
