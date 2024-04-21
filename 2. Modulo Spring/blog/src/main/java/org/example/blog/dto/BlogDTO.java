package org.example.blog.dto;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class BlogDTO {
    private Integer id;
    private String title;
    private String authorName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate postDate;
}
