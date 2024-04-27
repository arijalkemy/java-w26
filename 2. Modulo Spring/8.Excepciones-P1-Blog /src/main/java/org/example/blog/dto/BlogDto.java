package org.example.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BlogDto {
    private Integer id;
    private String title;
    private String nameAuthor;
    private LocalDate createTime;
}
