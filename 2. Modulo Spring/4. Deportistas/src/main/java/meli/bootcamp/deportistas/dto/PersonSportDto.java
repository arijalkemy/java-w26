package meli.bootcamp.deportistas.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonSportDto implements Serializable {
    private String name;
    private String surname;
    private String sport;


}
