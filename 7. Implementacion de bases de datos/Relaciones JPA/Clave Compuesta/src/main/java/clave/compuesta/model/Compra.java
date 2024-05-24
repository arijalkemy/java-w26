package clave.compuesta.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "compras")
@IdClass(CompraKey.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Compra {
    @Id
    private Long id;

    @Id
    private String fecha;
}