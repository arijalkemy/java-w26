package com.ejercicio.showroomnosql.entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDate;
import java.util.List;

@Document(indexName = "sells")
public class Sell {
    @Id
    private String id;
    @Field(type = FieldType.Date)
    private LocalDate date;
    @Field(type = FieldType.Double)
    private double total;
    @Field(type = FieldType.Text)
    private String paymentMethod;
    private List<Clothe> clothes;

    public Sell() {
        date = LocalDate.now();
    }
}
