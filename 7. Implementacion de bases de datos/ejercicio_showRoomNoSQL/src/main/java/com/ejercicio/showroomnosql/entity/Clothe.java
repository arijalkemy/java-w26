package com.ejercicio.showroomnosql.entity;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@Document(indexName = "clothes")
public class Clothe {
    @Id
    private String code;

    @Field(type = FieldType.Text)
    private String name;
    @Field(type = FieldType.Text)
    private String type;
    @Field(type = FieldType.Text)
    private String brand;
    @Field(type = FieldType.Text)
    private String colour;
    @Field(type = FieldType.Text)
    private String waist;
    @Field(type = FieldType.Integer)
    private int quantity;
    @Field(type = FieldType.Double)
    private double price;

    public Clothe() {
    }
}
