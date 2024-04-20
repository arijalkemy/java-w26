package com.javabootcamp.linktracker.DTO;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseDTO {
    String message;
    int statusCode;
}
