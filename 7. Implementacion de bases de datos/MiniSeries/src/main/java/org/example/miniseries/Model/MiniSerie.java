package org.example.miniseries.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class MiniSerie {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    Double rating;
    int amount_of_awards;
}
