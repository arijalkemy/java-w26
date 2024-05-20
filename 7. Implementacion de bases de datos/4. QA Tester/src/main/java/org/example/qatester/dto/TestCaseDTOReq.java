package org.example.qatester.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class TestCaseDTOReq {
    @NotBlank(message = "Description cannot be blank")
    private String description;

    @NotNull(message = "Tested cannot be null")
    private Boolean tested;

    @NotNull(message = "Tested cannot be null")
    private Boolean passed;

    @JsonProperty("number_of_tries")
    private int numberOfTries;

    @JsonProperty("last_update")
    @NotNull(message = "Last update cannot be null")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd")
    private LocalDate lastUpdate;
}
