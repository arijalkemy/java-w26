package com.example.demo.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(indexName = "sales")
public class Sale {

    @Id
    private Long id;
    private LocalDate date;
    private Double total;
    private String paymentMethod;
    private List<Clothes> clothesList;
}
