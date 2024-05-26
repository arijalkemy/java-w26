package com.example.ejerciciopracticoextraopcionales.dto.request;

import com.example.ejerciciopracticoextraopcionales.entity.Cloth;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaleRequestDTO {
    private LocalDate date;
    private Integer total;
    private String paymentMethod;
    private List<Cloth> cloths;
}