package org.example.integradorobrasliterarias.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDateTime;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Document(indexName = "book")
public class Book {
    @Id
    private String id;

    private String name;
    private String authorName;
    private Integer pages;
    private String editorial;

    private Integer publicationYear;
    

}
