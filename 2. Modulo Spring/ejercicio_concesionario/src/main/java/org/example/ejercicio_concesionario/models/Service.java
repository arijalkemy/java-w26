package org.example.ejercicio_concesionario.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Service {
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private String kilometers;
    private String descriptions;
}
