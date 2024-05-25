package com.example.qatester.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestCaseDto {
    @NonNull
    String description;
    @NonNull
    Boolean tested;
    @NonNull
    Boolean passed;
    int number_of_tries;
    @JsonFormat(pattern = "yyyy-MM-dd")
    Date last_update;
}
