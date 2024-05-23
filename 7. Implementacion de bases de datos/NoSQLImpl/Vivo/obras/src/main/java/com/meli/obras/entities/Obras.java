package com.meli.obras.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "obras")
@Data
@Getter
@Setter
public class Obras {
    @Id
    private String id;
    private String nombre;
    private String autor;
    private Integer páginas;
    private String editorial;
    private Integer publicacion;
}
