package practica.Miniseries.Entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "miniserie")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MiniSerie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private double rating;

    @Column
    private int amountOfAwards;
}
