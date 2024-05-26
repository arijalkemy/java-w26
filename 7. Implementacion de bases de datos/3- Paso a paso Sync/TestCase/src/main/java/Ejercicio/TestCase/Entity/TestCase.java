package Ejercicio.TestCase.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Table(name = "test_case")
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class TestCase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String description;

    @Column
    private boolean tested;

    @Column
    private boolean passed;

    @Column
    private Integer numberOfTries;

    @Column
    private LocalDate lastUpdate;
}
