package org.example.concesionaria.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public final class ServiceDTO {
    LocalDate date;
    String kilometers;
    String descriptions;
}
