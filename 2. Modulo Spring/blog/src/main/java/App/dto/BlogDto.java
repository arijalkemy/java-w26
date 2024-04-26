package App.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor

public class BlogDto implements Serializable {
    Integer id;
    String tituloDelBlog;
    String nombreDelAutor;
    String dateTime;
}
