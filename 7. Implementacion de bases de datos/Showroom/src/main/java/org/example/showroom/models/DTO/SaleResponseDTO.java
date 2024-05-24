package org.example.showroom.models.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class SaleResponseDTO {
    private Long number;
    private LocalDate saleDate;
    private BigDecimal totalCost;
    private String paymentMethod;
    private List<ClothesResponseDTO> clothes;
}
