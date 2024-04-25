package org.example._09concesionaria.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ServiceDTO implements Serializable {
    private String date;
    private Integer kilometers;
    private String descriptions;
}
