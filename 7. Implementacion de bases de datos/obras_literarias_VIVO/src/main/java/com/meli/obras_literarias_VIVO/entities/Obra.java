package com.meli.obras_literarias_VIVO.entities;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
@Builder
@Data
@Document(indexName = "obra_literaria")
public class Obra {
    @Id
    String id;
    String nombre;
    String autor;
    Integer cantidadDePaginas;
    String editorial;
    Integer año;
}
