package com.meli.Joyeria.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class CreateResponseDto {
    private String status;
    private Long id;
}
