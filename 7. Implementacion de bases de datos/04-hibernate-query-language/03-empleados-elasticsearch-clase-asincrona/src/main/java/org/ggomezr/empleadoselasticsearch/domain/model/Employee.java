package org.ggomezr.empleadoselasticsearch.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "employees")
public class Employee {
    private String id;
    private String name;
    private String lastName;
    private Integer age;
    private String city;
    private String province;
}
