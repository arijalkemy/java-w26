package bootcamp.bendezujonathan.cloth.model;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "sales")
public class Sale {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long numero;

    @Basic
    @CreationTimestamp
    private LocalDate fecha;

    @Basic
    private double total;

    @Column(name = "medio_de_pago")
    private String medioDePago;

    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL)
    private Set<SaleDetail> saleDetails;


}
