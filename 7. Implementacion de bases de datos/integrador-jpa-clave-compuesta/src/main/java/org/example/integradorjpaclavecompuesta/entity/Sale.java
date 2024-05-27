package org.example.integradorjpaclavecompuesta.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "sale")
@IdClass(value = SaleKey.class)
public class Sale {
    @Id
    @Column(name = "sale_id")
    private Long id;

    @Column(name = "date")
    @Id
    private String date;

    @Column(name = "element")
    private String element;

    @Column(name = "total")
    private Double total;
}
