package org.example.templatemvc.DTOs.Response;

import lombok.Data;

@Data
public class PatenteMarcaTotalPerdida {
    private String patente;
    private String marca;
    private Double totalPerdida;
}
