package com.meli.Obras.literarias.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.time.LocalDate;

@Document(indexName = "obra")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Obra {
    @Id
    private String id;
    private String nombre;
    private String autor;
    private Integer cantidadDePaginas;
    private String editorial;
    private LocalDate fechaPublicacion;
}
