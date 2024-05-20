package org.responseentity.jpa_demo.model;

import jakarta.persistence.*;
import lombok.Setter;
import lombok.Getter;

@Getter @Setter
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name")
    private String name;
}
