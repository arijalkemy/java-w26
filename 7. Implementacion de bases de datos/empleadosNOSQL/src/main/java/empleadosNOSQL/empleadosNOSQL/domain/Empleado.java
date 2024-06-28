package empleadosNOSQL.empleadosNOSQL.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

@Document(indexName = "blog")
@Data
public class Empleado {

    @Id
    private String id;
    private String nombre;
    private String apellido;
    private int edad;
    private String ciudad;
    private String departamento;



}
