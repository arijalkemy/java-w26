package org.example.blog.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class BlogEntry {
    private int id;
    private String title;
    private String authorName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate postDate;
}
