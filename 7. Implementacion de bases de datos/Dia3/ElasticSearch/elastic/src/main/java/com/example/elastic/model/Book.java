package com.example.elastic.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

//De cada obra literaria se debe poder almacenar el id, el nombre, autor, cantidad de páginas, editorial y el año de su primera publicación
@Document(indexName = "book")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    private String id;
    private String name;
    private String author;
    private int pages;
    private String editorial;
    private int year;

}
