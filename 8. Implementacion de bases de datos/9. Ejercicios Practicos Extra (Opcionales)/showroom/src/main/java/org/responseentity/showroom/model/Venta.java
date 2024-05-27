package org.responseentity.showroom.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate fechaVenta;
    private String medioPago;
    private Double total;

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "transaccion",
//            joinColumns = @JoinColumn(name = "venta_id", nullable = false),
//            inverseJoinColumns = @JoinColumn(name ="prenda_id", nullable = false)
//    )
//    private List<Prenda> prendas;
}
