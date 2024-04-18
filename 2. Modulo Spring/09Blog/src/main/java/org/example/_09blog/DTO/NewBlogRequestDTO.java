package org.example._09blog.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewBlogRequestDTO {
    private int id;
    private String title;
    private String author;
    private String publishDate;
}
