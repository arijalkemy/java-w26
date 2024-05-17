package meli.bootcamp.jpa_hibernate.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String dni;

    private String name;

    @Column(name = "last_name")
    private String lastName;
}
