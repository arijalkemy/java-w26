package com.example.demo.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.time.Year;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(indexName = "books")
public class Book {
    @Id
    private String id;
    private String name;
    private String author;
    private int pageCount;
    private String publisher;
    private Year publicationYear;
}