package bootcamp.jonathan.sports.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AthleteDto {
    private String name;
    private String surName;
    private String sportName;
}
