package org.ggomezr.empleadoselasticsearch.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeDTO {
    private String id;
    private String name;
    private String lastName;
    private Integer age;
    private String city;
    private String province;
}
