package org.bootcamp.concesionary.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
public class VehService {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private String kilometers;
    private String descriptions;
}
