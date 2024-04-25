package org.example.ejercicioblog.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class EntradaBlogDTO {
    private int id;
    private String titulo;
    private String autor;
    private String publicacion;
}
