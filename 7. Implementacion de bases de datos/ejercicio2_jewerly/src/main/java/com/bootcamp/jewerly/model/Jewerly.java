package com.bootcamp.jewerly.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "jewerly")
public class Jewerly {

    @Id
    @Column(name = "nro_identificatorio")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("nro_Identificatorio")
    private Long nroIdentificatorio;

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "material")
    private String material;
    @Column(name = "peso")
    private Double peso;
    @Column(name = "particularidad")
    private String particularidad;
    @Column(name = "posee_piedra")
    private Boolean poseePiedra;
    @Column(name = "venta_o_no")
    private Boolean ventaONo;

}