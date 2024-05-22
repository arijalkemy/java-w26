package jpa.lasperlas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Joya {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long nroIdentificatorio;

    private String nombre;
    private String material;
    private double peso;
    private String particularidad;
    private boolean poseePiedra;
    private boolean ventaONo;

}
