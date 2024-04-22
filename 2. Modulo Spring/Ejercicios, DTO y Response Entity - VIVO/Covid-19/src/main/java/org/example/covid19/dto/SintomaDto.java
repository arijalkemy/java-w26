package org.example.covid19.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SintomaDto implements Serializable {
    private long codigo;
    private String nombre;
    private String nivel_de_gravedad;
}
