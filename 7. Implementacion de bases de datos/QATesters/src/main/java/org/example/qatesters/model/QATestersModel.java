package org.example.qatesters.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "qa_testers")
public class QATestersModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_case;

    @Column(name = "descripcion")
    private String description;

    @Column(name = "tested")
    private boolean tested;

    @Column(name = "passed")
    private boolean passed;

    @Column(name = "nummero de intentos")
    private int numberOfTries;

    @Column(name = "Ultima actualizacion")
    private LocalDate lastUpdate;
}
