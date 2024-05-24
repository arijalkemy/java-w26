package org.example.ejercicios_extra_elasticsearch.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.annotation.Id;

@Document(indexName = "venta")

@Getter @Setter
@NoArgsConstructor
public class Venta {
    @Id
    private String numero;

    private LocalDate fecha;

    private BigDecimal total;

    private String medioDePago;

    private List<Prenda> prendas;
}