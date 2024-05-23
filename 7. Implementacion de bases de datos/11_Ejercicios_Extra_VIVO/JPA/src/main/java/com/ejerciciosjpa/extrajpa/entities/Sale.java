package com.ejerciciosjpa.extrajpa.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "ventas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numero;
    private LocalDate fecha;
    private Double total;
    private String medioDePago;
    @OneToMany(mappedBy = "ventas")
    private List<Cloth> clothes;
}
