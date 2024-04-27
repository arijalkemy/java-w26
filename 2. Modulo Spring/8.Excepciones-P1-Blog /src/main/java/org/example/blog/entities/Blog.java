package org.example.blog.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog {
    public static int idAuto = 1;
    private Integer id;
    private String title;
    private String nameAuthor;
    private LocalDate createTime;
}
