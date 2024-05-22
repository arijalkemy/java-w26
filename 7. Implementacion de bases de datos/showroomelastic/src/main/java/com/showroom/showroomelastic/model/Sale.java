package com.showroom.showroomelastic.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDate;
import java.util.List;

@Document( indexName = "sales")
@Getter @Setter
public class Sale {
    //numero, fecha, total, medio de pago, lista de prendas.
    @Id
    private String id;

    @Field(type = FieldType.Date, format = DateFormat.basic_date)
    private LocalDate date;

    private double totalPrice;

    private String paymentMethod;

    //@OneToMany( cascade = CascadeType.ALL)
    @Field(type = FieldType.Nested, includeInParent = true)
    List<Cloth> clothes;
}
