package com.example.sinisestros.dto;

import lombok.*;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ListPatentesyMarcasDTO {
    List<Map<String, String>> listPatentesMarcas;
}
