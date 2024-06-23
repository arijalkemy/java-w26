package org.example.clavescompuestas.entity;

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
    @Column(name = "cliente_id")
    private Long clienteId;
    @Id
    @Column(name = "fecha")
    private LocalDate fecha;
    @Column(name = "valor")
    private Double valor;
    @Column(name = "ciudad")
    private String ciudad;
    @Column(name = "observacion")
    private String observacion;
    @Column(name = "numero_tienda")
    private Integer numeroTienda;
    @Column(name = "tipo_pago")
    private String tipoPago;
}
