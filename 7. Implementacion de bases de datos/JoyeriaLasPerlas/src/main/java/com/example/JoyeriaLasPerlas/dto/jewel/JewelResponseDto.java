package com.example.JoyeriaLasPerlas.dto.jewel;


import lombok.Data;

@Data
public class JewelResponseDto {
    private Long id;
    private final String message = "Jewel created successfully";
    private int statusCode;
}
