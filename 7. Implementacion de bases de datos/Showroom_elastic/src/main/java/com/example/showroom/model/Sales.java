package com.example.showroom.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDate;
import java.util.List;

@Document(indexName = "sales")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Sales {
    @Id
    private String id;

    @Field(type = FieldType.Date)
    private LocalDate date;

    @Field(type = FieldType.Double)
    private double total;

    @Field(type = FieldType.Keyword)
    private String methodOfPay;

    @Field(type = FieldType.Nested)
    private List<Clothes> listOfClothes;
}