package com.implementaciondb.ejercicio11_showroom_elasticsearch.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(indexName = "clothes")
public class Garment {

    @Id
    private String code;

    @Field(type = FieldType.Text)
    private String name;

    @Field(type = FieldType.Text)
    private String type;

    @Field(type = FieldType.Text)
    private String brand;

    @Field(type = FieldType.Text)
    private String color;

    @Field(type = FieldType.Integer)
    private Integer size;

    @Field(type = FieldType.Integer)
    private Integer quantity;

    @Field(type = FieldType.Double)
    private Double salePrice;

}
