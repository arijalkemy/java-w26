package com.example.showroom.model.dto;

import com.example.showroom.model.Clothes;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestedAddSaleDto {
    private String methodOfPay;
    private List<Long> listOfIDClothes;
}
