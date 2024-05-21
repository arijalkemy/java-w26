package org.example.obrasliterarias.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter
@Setter

@Document(indexName = "obra_literaria")
public class Obra {
    @Id
    private String id;
    private String nombre;
    private String autor;
    private Integer paginas;
    private String editorial;
    private Integer anioPublicacion;
}
