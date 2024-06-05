package org.example.testjpahql.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class MovieDTO {

    private String title;
    private BigDecimal rating;
    private Integer awards;
    private LocalDateTime releaseDate;
    private Integer length;

}
