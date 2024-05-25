package com.example.demo.model.dto.saleDTO;

import com.example.demo.model.entity.Clothes;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SaleRequestDTO {
    private LocalDate date;
    private Double total;
    private String paymentMethod;
    private List<Clothes> clothesList;
}
