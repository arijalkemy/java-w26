package org.meli.ejercicio6_p4_d1_seriesparte2_mysql.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieDto {
    private String title;
    private Double rating;
    private Integer awards;
    private String genre;
}
