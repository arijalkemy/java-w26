package co.com.mercadolibre.empleados.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "empleados")
public class Empleado {

    @Id
    private String id;
    private String nombre;
    private String apellido;
    private Integer edad;
    private String ciudad;
    private String provincia;
}
