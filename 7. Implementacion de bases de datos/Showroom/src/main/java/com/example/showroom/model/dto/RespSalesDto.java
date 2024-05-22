package com.example.showroom.model.dto;

import com.example.showroom.model.Clothes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespSalesDto {
    private Long id;
    private LocalDate date;
    private double total;
    private String methodOfPay;
    private List<Clothes> listOfClothes;
}
