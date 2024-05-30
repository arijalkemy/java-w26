package com.mercadolibre.Obras_Literarias.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(indexName = "obras_literarias")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ObraLiteraria {
    @Id
    String id;
    String nombre;
    String autor;
    Integer cantidadPaginas;
    String editorial;
    Integer anioPublicacion;
}
