package org.ejercicio.conocesionaria.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class ServiceDTO  implements Serializable {
    private LocalDate date;
    private int kilometers;
    private String descriptions;
}
