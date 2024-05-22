package bootcamp.vivo.obras.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(indexName = "obras_")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Obra {
    
    @Id
    private String id;
    private String nombre;
    @Field(type = FieldType.Nested, includeInParent = true)
    private Autor autor;
    @Field(type = FieldType.Nested, includeInParent = true)
    private Editorial editorial;
    private Integer cantidadPaginas;
    @Field(type = FieldType.Date, includeInParent = true, format = DateFormat.basic_date)
    private LocalDate fechaPrimerPublicacion;
}
