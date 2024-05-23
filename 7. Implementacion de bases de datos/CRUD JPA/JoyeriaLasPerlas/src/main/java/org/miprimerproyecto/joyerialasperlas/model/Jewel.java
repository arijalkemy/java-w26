package org.miprimerproyecto.joyerialasperlas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Jewel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long nro_identificatorio;
    private String nombre;
    private String material;
    private int peso;
    private String particularidad;
    private boolean posee_piedra;
    private boolean ventaONo;

    public Jewel(long nro_identificatorio, String nombre, String material, int peso, String particularidad,
                 boolean posee_piedra, boolean ventaONo) {
        this.nro_identificatorio = nro_identificatorio;
        this.nombre = nombre;
        this.material = material;
        this.peso = peso;
        this.particularidad = particularidad;
        this.posee_piedra = posee_piedra;
        this.ventaONo = ventaONo;
    }

    public Jewel() {

    }
}
