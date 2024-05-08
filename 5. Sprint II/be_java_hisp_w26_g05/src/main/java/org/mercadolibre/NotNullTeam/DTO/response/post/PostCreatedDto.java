package org.mercadolibre.NotNullTeam.DTO.response.post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
public class PostCreatedDto {
    private Long id;
    private String message;
    private LocalDate date;
}
