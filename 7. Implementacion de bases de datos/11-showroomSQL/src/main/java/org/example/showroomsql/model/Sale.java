package org.example.showroomsql.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "sales")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long number;
    private LocalDate date;
    private Integer total;
    private String paymentMethod;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "sales_clothes",
            joinColumns = @JoinColumn(name = "sale_id"),
            inverseJoinColumns = @JoinColumn(name = "clothes_id"))
    private List<Clothes> clothes;
}
