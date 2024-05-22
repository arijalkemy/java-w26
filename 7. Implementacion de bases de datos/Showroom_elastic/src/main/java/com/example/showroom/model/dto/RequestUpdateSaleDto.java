package com.example.showroom.model.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestUpdateSaleDto {
    private String id;
    private LocalDate date;
    private double total;
    private String methodOfPay;
    private List<String> listOfIDClothes;
}
