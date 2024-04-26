package com.Ejercicio.Youtuber.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntryBlog {
    private Integer id;
    private String title;
    private String authorName;
    private LocalDate datePublication;
}
