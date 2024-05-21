package org.example.es_hib_empleados.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExceptionDto {
    private String message;
    private String uri;
}
