package com.group03.sprint1.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class MessageResponseDTO implements Serializable {
    private String message;
}
