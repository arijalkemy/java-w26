package org.example.integradorvehiculossiniestros.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter @Getter
@Entity
@Table(name = "accident_registry")
public class AccidentRegistry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "accident_date")
    private LocalDateTime accidentDate;

    @Column(name = "money_loss")
    private BigDecimal moneyLoss;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    @JsonBackReference
    private Vehicle vehicle;

}
