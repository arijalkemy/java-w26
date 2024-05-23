package org.example.showroom.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private LocalDate date;
    private Double total;
    @JsonProperty("payment_method")
    @Column(name = "payment_method")
    private String paymentMethod;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "sale_clothes",
            joinColumns = @JoinColumn(name = "sale_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "clothes_id", nullable = false))
    private List<Clothe> clotheList;
}
