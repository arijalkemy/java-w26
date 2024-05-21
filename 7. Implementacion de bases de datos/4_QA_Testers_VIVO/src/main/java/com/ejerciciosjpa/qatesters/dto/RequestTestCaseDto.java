package com.ejerciciosjpa.qatesters.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class RequestTestCaseDto {
    private String description;
    private boolean tested;
    private boolean passed;
    private LocalDate last_updated;
}
