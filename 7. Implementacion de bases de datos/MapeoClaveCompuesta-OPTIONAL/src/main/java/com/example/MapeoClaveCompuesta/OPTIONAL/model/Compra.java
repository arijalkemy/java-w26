package com.example.MapeoClaveCompuesta.OPTIONAL.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "compras")
@IdClass(CompraId.class)
public class Compra {
    @Id
    private Long clienteId;
    @Id
    private Double fecha;
    private Integer total;
}
