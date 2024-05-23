package com.meli.obras.model;

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
    private String titulo;
    private String autor;
    private Integer paginas;
    private String editorial;
    private Integer publicacion;
}
