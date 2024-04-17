package org.ggomezr.deportistas.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Deporte {
    private String nombre;
    private String nivel;
}
