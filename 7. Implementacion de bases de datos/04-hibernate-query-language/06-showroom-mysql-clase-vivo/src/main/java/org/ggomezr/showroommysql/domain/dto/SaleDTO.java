package org.ggomezr.showroommysql.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SaleDTO {
    private Long code;
    private LocalDate date;
    private Double total;
    private String paymentMethod;
    private List<ClothingDTO> clothingList;
}
