package org.example._09concesionaria.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Service {
    private String date;
    private Integer kilometers;
    private String descriptions;
}
