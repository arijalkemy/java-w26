package com.showroom.showroomelastic.dto;

import com.showroom.showroomelastic.model.Cloth;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class SaleRequestDTO {
        private LocalDate date;
        private String paymentMethod;
        private List<Cloth> clothes;
}
