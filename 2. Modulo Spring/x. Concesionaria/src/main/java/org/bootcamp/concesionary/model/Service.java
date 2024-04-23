package org.bootcamp.concesionary.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Service {
    private String date;
    private String kilometers;
    private String descriptions;
}
