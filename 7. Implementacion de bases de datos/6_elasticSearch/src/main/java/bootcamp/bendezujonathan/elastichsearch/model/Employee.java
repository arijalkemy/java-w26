package bootcamp.bendezujonathan.elastichsearch.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(indexName = "employee")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    

    @Id
    private String id;
    private String nombre;
    private int edad;
    
    @Field(type = FieldType.Nested, includeInParent = true)
    private Ciudad ciudad;


    @Field(type = FieldType.Nested, includeInParent = true)
    private Provincia provincia;

}
