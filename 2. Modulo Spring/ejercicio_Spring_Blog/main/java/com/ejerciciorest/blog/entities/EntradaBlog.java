package com.ejerciciorest.blog.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EntradaBlog {
    private Integer id;
    private String titulo;
    private String nombre;
    private LocalDate fechaCreacion;
}
