package bootcamp.bd.joyeria.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "Joyas")
public class Joya {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nro_identificatorio")
    private Long id;
    private String nombre;
    private String material;
    private Integer gramos;
    private String particularidad;
    @Column(name = "posee_piedra")
    private Boolean poseePiedra;
    @Column(name = "venta_o_no")
    private Boolean ventaONo;
}
