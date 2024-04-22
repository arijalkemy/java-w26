package org.ejercicio.conocesionaria.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceDTO  implements Serializable {
    private UUID id;
    private LocalDate date;
    private int kilometers;
    private String descriptions;
}
