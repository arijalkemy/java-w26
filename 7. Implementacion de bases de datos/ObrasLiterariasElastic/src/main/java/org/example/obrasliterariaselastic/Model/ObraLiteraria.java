package org.example.obrasliterariaselastic.Model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "obra_literaria")
@Data
@Builder
public class ObraLiteraria {
    @Id
    private String id;

    private String nombre;

    private String autor;

    private Integer cantidadDePaginas;

    private String editorial;

    private Integer anioPrimeraPublicacion;
}
