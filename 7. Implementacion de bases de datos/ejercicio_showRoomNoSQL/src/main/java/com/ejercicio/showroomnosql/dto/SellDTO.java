package com.ejercicio.showroomnosql.dto;

import com.ejercicio.showroomnosql.entity.Clothe;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class SellDTO {
    private int id;
    private LocalDate date;
    private double total;
    private String paymentMethod;
    private List<Clothe> clothes;
}
