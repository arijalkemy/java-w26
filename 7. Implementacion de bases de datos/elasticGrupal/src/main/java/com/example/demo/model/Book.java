package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

@Document(indexName = "books")
@Getter
@Setter
public class Book {
    @Id
    private String id;
    private String title;
    private String author;
    private String publisher;
    private int pages;
    private Date publishedDate;
}
