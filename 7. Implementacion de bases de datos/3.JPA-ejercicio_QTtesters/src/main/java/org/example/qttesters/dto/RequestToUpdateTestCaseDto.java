package org.example.qttesters.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class RequestToUpdateTestCaseDto {
    private Long id;
    private String description;
    private boolean tested;
    private boolean passed;
    private LocalDate last_updated;
}
