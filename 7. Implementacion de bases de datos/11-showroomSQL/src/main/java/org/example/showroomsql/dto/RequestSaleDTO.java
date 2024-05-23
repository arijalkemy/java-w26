package org.example.showroomsql.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.showroomsql.model.Clothes;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestSaleDTO {
    private LocalDate date;
    private Integer total;
    private String paymentMethod;
    private List<ResponseClothesDTO> clothes;
}
