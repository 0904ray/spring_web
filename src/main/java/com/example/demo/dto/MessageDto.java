package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessageDto {
    private Integer id;
    private String message;
    private String date;
    private String hour;
    private boolean notified;

}
