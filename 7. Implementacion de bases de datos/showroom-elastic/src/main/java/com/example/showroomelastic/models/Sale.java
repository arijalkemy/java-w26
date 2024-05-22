package com.example.showroomelastic.models;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Data
@Document(indexName = "sales")
public class Sale {
    @Id
    private String id;
    private String numero;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Long fecha;
    private Double total;
    private String medioDePago;
    private List<Clothe> prendas;
}
