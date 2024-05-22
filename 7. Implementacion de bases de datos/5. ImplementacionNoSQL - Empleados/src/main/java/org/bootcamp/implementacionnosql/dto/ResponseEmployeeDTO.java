package org.bootcamp.implementacionnosql.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseEmployeeDTO {
    private String id;
    private String name;
    private String surname;
    private Integer age;
    private String city;
    private String place;
}
