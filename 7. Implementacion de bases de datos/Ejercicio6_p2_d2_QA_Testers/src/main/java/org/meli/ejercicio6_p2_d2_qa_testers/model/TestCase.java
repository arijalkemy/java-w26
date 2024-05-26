package org.meli.ejercicio6_p2_d2_qa_testers.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "testCases")
public class TestCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="description", nullable = false)
    private String description;
    @Column(name="tested", nullable = false)
    private Boolean tested;
    @Column(name="passed", nullable = false)
    private Boolean passed;
    @Column(name="number_of_tries", nullable = false)
    private Integer number_of_tries;
    @Column(name="last_update")
    private LocalDate last_update;

}
