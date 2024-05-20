package com.meli.QA.Testers.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ResponseDto {
    private String status;
    private Long id;
    private String message;
}
