package org.example.apiobrasliterarias.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "obras_literarias")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ObraLiterariaModel {
    @Id
    private String id;

    private String nombre;
    private String autor;
    private int cantidadPaginas;
    private String editorial;
    private int anioPublicacion;
}
