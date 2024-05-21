package com.obrasliterariaseelastic.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "obras_literarias")
@Data
public class ObraLiteraria {
    @Id
    private String id;
    private String name;
    private String autor;
    private Integer cantPaginas;
    private String editorial;
    private Integer anioPublicacion;
}
