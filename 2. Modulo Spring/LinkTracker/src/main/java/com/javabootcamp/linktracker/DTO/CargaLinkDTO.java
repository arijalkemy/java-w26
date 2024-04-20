package com.javabootcamp.linktracker.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CargaLinkDTO {
    private Integer id;
    private String url;
    private String password;
}
