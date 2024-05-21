package org.example.qttesters.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ResponseTestCaseDto {
    private Long id_case;
    private String description;
    private boolean tested;
    private boolean passed;
    private LocalDate last_updated;
}
