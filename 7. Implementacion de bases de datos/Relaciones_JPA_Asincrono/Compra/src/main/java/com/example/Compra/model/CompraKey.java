package com.example.Compra.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompraKey implements Serializable {
    private Long clienteId;
    private LocalDate fecha;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompraKey that = (CompraKey) o;
        return Objects.equals(clienteId, that.clienteId) &&
                Objects.equals(fecha, that.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clienteId, fecha);
    }
}
