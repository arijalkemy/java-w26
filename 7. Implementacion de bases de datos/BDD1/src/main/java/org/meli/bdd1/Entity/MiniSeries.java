package org.meli.bdd1.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MiniSeries {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false, length = 25)
    private String name;

    @Column()
    private Double rating;

    @Column(name = "amount_of_awards")
    private Integer amountOfAwards;

}
