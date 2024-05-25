package org.example.tiendadeprendas.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "venta")
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long idVenta;
    LocalDate fecha;
    String medioPago;
    Double precioTotal;
    @ManyToMany()
    @JoinTable(joinColumns = @JoinColumn(name = "venta_id"),
            inverseJoinColumns = @JoinColumn(name = "prenda_id")
    )
    List<Prenda> prendaLista;
}
