package ejercicio.Crud.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Table(name = "jewel")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Jewel {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column
    private String name;

    @Column
    private String material;

    @Column
    private boolean hasStone;

    @Column
    private double Weight;

    @Column
    private String particularity;

    @Column
    private boolean soldOrNot;
}
