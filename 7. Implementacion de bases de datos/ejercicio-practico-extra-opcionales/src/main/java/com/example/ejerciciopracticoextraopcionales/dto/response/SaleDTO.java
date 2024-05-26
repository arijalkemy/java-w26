package com.example.ejerciciopracticoextraopcionales.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SaleDTO {

    private Long number;
    private LocalDate date;
    private Integer total;
    private String paymentMethod;
    private List<ClothDTO> cloths;
}
