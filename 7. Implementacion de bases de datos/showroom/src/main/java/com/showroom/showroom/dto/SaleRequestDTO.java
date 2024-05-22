package com.showroom.showroom.dto;

import com.showroom.showroom.model.Cloth;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class SaleRequestDTO {
        private LocalDate date;
        private String paymentMethod;
        private List<ClothRequestDTO> clothes;
}
