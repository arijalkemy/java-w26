package com.example.Sports.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
@Data
@AllArgsConstructor
public class SportDTO implements Serializable {
    private String level;
}
