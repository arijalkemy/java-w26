package org.example.integradorvehiculossiniestros.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class AccidentRegistryRequestDTO {
    private LocalDateTime accidentDate;
    private BigDecimal moneyLoss;
}
