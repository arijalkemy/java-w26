package org.mercadolibre.NotNullTeam.DTO.response;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromoPostCreateDTO {
    private Long id;
    private String message;
    private LocalDate date;
}
