package org.ggomezr.showroommysql.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sale")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;
    private LocalDate date;
    private Double total;
    private String paymentMethod;

    @ManyToMany
    @JoinTable(
            name = "sale_clothing",
            joinColumns = @JoinColumn(name = "sale_code"),
            inverseJoinColumns = @JoinColumn(name = "clothing_code")
    )
    private List<Clothing> clothingList;
}
