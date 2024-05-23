package com.prendas.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VentaPrenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "venta_id")
    private Venta venta;
    @ManyToOne
    @JoinColumn(name = "prenda_id")
    @JsonBackReference
    private Prenda prenda;
    private Integer cantidad;
    private Double precioUnitario;

}
