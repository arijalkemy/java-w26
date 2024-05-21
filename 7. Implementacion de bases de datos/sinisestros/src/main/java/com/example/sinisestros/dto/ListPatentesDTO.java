package com.example.sinisestros.dto;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ListPatentesDTO {
    List<String> patentes;
}
