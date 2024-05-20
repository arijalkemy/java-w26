package com.example.relaciones.model.oneToOne;

import com.example.relaciones.model.oneToOne.Address;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private String surname;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;
}
