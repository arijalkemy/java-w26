package com.bootcamp.qatesters.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestCase {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String descripcion;
    private boolean tested;
    private boolean passed;
    private int number_of_tries;
    @Column(name = "last_update")
    private LocalDate lastUpdate;


}
