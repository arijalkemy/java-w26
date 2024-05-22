package com.example.showroom.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "clothes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Clothes {
    @Id
    private String id;

    @Field(type = FieldType.Text)
    private String description;

    @Field(type = FieldType.Text)
    private String color;

    @Field(type = FieldType.Text)
    private String size;

    @Field(type = FieldType.Text)
    private String material;

    @Field(type = FieldType.Text)
    private String brand;

    @Field(type = FieldType.Double)
    private double price;

    @Field(type = FieldType.Text)
    private String type;
}
