package com.prendas.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long number;
    private LocalDate fecha;
    private Double total;
    private String medioDePago;
    @OneToMany(mappedBy = "venta", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<VentaPrenda> listaDePrendas = new ArrayList<>();

    public void addVentaPrenda(VentaPrenda ventaPrenda) {

        if(this.listaDePrendas == null) {
            this.listaDePrendas = new ArrayList<>();
        }

        this.listaDePrendas.add(ventaPrenda);
    }
}
