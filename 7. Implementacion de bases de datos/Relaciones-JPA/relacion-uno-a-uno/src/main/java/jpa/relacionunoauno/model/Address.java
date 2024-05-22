package jpa.relacionunoauno.model;

import jakarta.persistence.*;

@Entity
@Table(name="address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;
    @OneToOne(mappedBy = "address")
    private User user;
}
