package org.mercadolibre.NotNullTeam.DTO.response.post;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostCreatedDto {
    private Long id;
    private String message;
    private LocalDate date;
}
