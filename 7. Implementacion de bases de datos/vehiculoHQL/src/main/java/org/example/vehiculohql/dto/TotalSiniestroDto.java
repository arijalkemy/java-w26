package org.example.vehiculohql.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

public interface TotalSiniestroDto {
    String getPatente();
    String getMarca();
    String getModelo();
    Double getTotal();
}
