package org.bootcamp.concesionary.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
public class ServiceDTO {
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private String kilometers;
    private String descriptions;
}
