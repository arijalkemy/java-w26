package org.bootcamp.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class BlogDTO {
    private Integer id;
    private String title;
    private String author;
    private String date;
}
