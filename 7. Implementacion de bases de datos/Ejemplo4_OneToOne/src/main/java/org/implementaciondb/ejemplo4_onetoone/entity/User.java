package org.implementaciondb.ejemplo4_onetoone.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL) // Indica relación uno a uno con Address
    @JoinColumn(name = "address_id", referencedColumnName = "id") // Define el nombre de la columna en la tabla users que mapea la clave primaria de la tabla Adddress
    private Address address;
}
