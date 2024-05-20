package org.example.llavescompuestas.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import org.example.llavescompuestas.models.keys.CompraKey;

import java.time.LocalDate;
@Entity
@Table(name = "compra")
@IdClass(value = CompraKey.class)
public class Compra {
    @Id
    private Long clienteId;
    @Id
    private LocalDate fecha;
}
