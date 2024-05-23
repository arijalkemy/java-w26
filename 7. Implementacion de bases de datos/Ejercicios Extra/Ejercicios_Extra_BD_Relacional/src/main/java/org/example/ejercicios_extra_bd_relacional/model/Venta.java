package org.example.ejercicios_extra_bd_relacional.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@Entity
@Table(name = "venta")
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "numero", nullable = false)
    private int numero;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "total", nullable = false)
    private BigDecimal total;

    @Column(name = "medio_de_pago", nullable = false)
    private String medioDePago;

    @ManyToMany
    @JoinTable(name = "prenda_venta",
            joinColumns = @JoinColumn(name = "venta_numero"),
            inverseJoinColumns = @JoinColumn(name = "prenda_id"))
    private List<Prenda> prendas;
}