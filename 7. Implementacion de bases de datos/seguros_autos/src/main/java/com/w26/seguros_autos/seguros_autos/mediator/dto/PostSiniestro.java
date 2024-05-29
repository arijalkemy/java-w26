package com.w26.seguros_autos.seguros_autos.mediator.dto;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Data;

@Data
public class PostSiniestro implements Serializable {
    LocalDate fechaSiniestro;
    Double perdidaEconomica;
}
