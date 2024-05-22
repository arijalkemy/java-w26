package org.example.obrasliterarias.model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "libro")
@Setter @Getter
public class Libro {
    @Id
    private String id;
    private String nombre;
    private String autor;
    private Integer paginas;
    private String editorial;

    @Field(type = FieldType.Date, format = DateFormat.year)
    private int ano;
}
