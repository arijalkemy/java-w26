package com.example.link.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MetricResponseDTO {
    private int id;
    private int cantidadDeVecesQueSeRedirecciono;
}
