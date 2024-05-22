package com.example.showroom.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestedAddSaleDto {
    private LocalDate date;
    private double total;
    private String methodOfPay;
    private List<String> listOfIDClothes;
}
