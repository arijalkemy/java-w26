package org.bootcamp.concesionary.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ServiceDTO {
    private String date;
    private String kilometers;
    private String descriptions;
}
