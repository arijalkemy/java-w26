package org.miprimerproyecto.elasticempleado.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "empleado")
@Data
public class Employee {
    @Id
    private String id;
    private String first_name;
    private String last_name;
    private int age;
    private String city;
    private String state;

}
