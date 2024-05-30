package meli.bootcamp.obrasliterarias.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

@Document(indexName = "obras")
@Data
public class ObraLiteraria {
    @Id
    String id;

    @Field(name = "nombre")
    String nombre;

    @Field(name = "autor")
    String autor;

    @Field(name = "cantidad_paginas")
    @JsonProperty("cantidad_paginas")
    Integer cantidadPaginas;

    @Field(name = "editorial")
    String editorial;

    @Field(name = "anio_primera_publicacion")
    @JsonProperty("anio_primera_publicacion")
    Integer anioPrimeraPublicacion;

}
