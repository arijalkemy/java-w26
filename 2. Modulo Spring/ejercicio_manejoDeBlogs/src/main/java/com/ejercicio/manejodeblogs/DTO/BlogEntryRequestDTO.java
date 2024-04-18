package com.ejercicio.manejodeblogs.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BlogEntryRequestDTO {
    private String title;
    private String authorName;
    private LocalDateTime date;
}
