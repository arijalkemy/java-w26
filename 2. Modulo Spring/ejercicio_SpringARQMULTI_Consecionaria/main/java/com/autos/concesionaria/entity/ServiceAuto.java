package com.autos.concesionaria.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ServiceAuto {
    private LocalDate fechaService;
    private Integer kilometrosHastaService;
    private String Descripcion;
}
