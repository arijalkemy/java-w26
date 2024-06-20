package org.example.youtuber.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogDTO {
    private Integer id;
    private String title;
    private String author;
    private LocalDate publicationDate;
}
