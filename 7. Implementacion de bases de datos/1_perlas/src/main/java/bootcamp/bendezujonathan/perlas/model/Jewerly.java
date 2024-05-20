package bootcamp.bendezujonathan.perlas.model;

import java.util.Objects;

import jakarta.persistence.Basic;
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
@Table(name = "jewerly")
public class Jewerly {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "nro_identificatorio")
    private Long nroIdentificatorio;

    @Basic
    private String nombre;

    @Basic
    private String material;

    @Basic
    private Double peso;

    @Basic
    private String particularidad;

    @Column(name = "posee_piedra")
    private Boolean poseePiedra;

    @Column(name = "venta_o_no")
    private boolean ventaONo; 


    public void update(Jewerly jewerly) {
        nombre = (!Objects.isNull(jewerly.nombre)) ? jewerly.nombre : nombre;
        material =  (!Objects.isNull(jewerly.material)) ? jewerly.material : material;
        peso =  (!Objects.isNull(jewerly.peso)) ? jewerly.peso : peso;
        particularidad = (!Objects.isNull(jewerly.particularidad)) ? jewerly.particularidad : particularidad;
        poseePiedra =  (!Objects.isNull(jewerly.poseePiedra)) ? jewerly.poseePiedra : poseePiedra;
    }

}
