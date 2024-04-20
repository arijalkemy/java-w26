package com.meli.ejercicioenvivovehiculo.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseDTO {
    String message;
    int statusCode;
}
