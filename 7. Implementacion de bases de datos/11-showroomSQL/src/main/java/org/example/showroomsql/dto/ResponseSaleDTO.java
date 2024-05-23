package org.example.showroomsql.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseSaleDTO {
    private Long number;
    private LocalDate date;
    private Integer total;
    private String paymentMethod;
    private List<ResponseClothesDTO> clothes;
}
