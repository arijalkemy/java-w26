package org.meli.ejercicio6_p4_d1_seriesparte2_mysql.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SerieDto {
    private String title;
    private Integer numberSeasons;
}
