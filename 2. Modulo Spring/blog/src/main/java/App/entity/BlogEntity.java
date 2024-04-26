package App.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BlogEntity {
    Integer id;
    String tituloDelBlog;
    String nombreDelAutor;
    String dateTime;
}
