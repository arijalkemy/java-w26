package com.ejerciciorest.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EntradaBlogDTO {
    private Integer id;
    private String titulo;
    private String nombre;
    private LocalDate fechaCreacion;

}
