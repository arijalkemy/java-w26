package org.ejercicio.apiobrasliterarias.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "obras_literarias")
public class ObraLiteraria {
    @Id
    private String id;
    private String nombre;
    private String autor;
    private Integer cantidadDePaginas;
    private String editorial;
    private Integer anioPrimeraPublicacion;
}
