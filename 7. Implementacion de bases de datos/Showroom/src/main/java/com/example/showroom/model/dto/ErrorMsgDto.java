package com.example.showroom.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorMsgDto {
    private String message;
    private String uri;
}
