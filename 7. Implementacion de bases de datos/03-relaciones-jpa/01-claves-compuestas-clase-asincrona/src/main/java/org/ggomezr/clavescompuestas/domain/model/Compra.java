package org.ggomezr.clavescompuestas.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "compras")
@IdClass(value = CompraKey.class)
public class Compra {

    @Id
    private Integer id;

    @Id
    private Integer numCompra;

    private LocalDate fecha;
    private Double total;
    private String descripcion;
}
