package org.example.miniseries.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@Entity
@Table(name= "miniseries")

public class MiniSerie {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    Double rating;
    Integer amountOfAwards;
}
