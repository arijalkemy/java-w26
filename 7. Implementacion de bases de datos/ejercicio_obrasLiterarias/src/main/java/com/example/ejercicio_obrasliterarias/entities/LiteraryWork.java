package com.example.ejercicio_obrasliterarias.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "literarywork")
@Data
public class LiteraryWork {
    @Id
    private String id;

    @Field(type = FieldType.Text)
    private String name;
    @Field(type = FieldType.Text)
    private String author;
    @Field(type = FieldType.Integer)
    private int quantity;
    @Field(type = FieldType.Integer)
    private int pages;
    @Field(type = FieldType.Text)
    private String editorial;
    @Field(type = FieldType.Integer)
    private int firstPublicationYear;
}
