package com.spring.deportistas.Models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaDto implements Serializable {
    private String fullName;
    private List<String> nombreDeporteList;
}
