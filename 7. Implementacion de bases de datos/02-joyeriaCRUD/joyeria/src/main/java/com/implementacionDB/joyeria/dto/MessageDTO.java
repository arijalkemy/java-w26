package com.implementacionDB.joyeria.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Setter
@Getter
public class MessageDTO implements Serializable {
    private String message;
}
