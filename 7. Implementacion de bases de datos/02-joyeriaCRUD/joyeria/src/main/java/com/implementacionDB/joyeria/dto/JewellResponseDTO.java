package com.implementacionDB.joyeria.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class JewellResponseDTO implements Serializable{
        private Long nroIdentificatorio;
        private String nombre;
        private String material;
        private Double peso;
        private String particularidad;
        private Boolean poseePiedra;
        private Boolean VentaONo;


}
