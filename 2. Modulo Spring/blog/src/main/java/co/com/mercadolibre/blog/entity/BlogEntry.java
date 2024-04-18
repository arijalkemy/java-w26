package co.com.mercadolibre.blog.entity;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BlogEntry {

    private Integer id;
    private String title;
    private String authorName;
    private String publicationDate;
}
