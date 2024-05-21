package com.bootcamp.JPAImplementation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CalificacionDto {
    private Long alumno_id;
    private Float promedio;
}
