package org.example.be_java_hisp_w26_g07.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Location {
    private Integer id;
    private Integer userId;
    private Float latitud;
    private Float longitud;
}
