package bootcamp.bendezujonathan.cloth.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clothes")
public class Cloth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long codigo;
    @Basic
    private String nombre;
    @Basic
    private String tipo;
    @Basic
    private String marca;
    @Basic
    private String color;
    @Basic
    private Integer cantidad;

    @Basic
    private String talle;

    @Column(name = "precio_venta")
    private Double precioVenta;

}
