package org.example.integradorqatesters.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "testcase")
public class TestCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_case")
    private Long idCase;

    @Column(name = "description")
    private String description;

    @Column(name = "tested")
    private boolean tested;

    @Column(name = "passed")
    private boolean passed;

    @Column(name = "number_of_tries")
    private Integer numberOfTries;

    @Column(name = "last_update")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate lastUpdate;
}
