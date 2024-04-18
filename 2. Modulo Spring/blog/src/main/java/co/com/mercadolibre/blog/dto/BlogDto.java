package co.com.mercadolibre.blog.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BlogDto {

    private Integer id;
    private String title;
    private String authorName;
    private String publicationDate;
}
