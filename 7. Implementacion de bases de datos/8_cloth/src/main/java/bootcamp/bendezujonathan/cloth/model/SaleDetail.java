package bootcamp.bendezujonathan.cloth.model;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "sale_details")
public class SaleDetail {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "precio_individual")
    private double precioIndividual;

    @Column
    private Integer cantidad;

    @ManyToOne
    @JoinColumn(name = "sale_id")
    private Sale sale;

    @ManyToOne
    @JoinColumn(name = "cloth_id")
    private  Cloth cloth;


    public Double calculateSubTotal(){
        return  cantidad * precioIndividual;
    }

}
