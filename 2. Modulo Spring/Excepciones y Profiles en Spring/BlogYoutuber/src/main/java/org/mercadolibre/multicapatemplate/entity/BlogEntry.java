package org.mercadolibre.multicapatemplate.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class BlogEntry {
    private Integer id;
    private String title;
    private String authorName;
    private LocalDateTime publicationDate;

    public BlogEntry(Integer id, String title, String authorName) {
        this.id = id;
        this.title = title;
        this.authorName = authorName;
        this.publicationDate = LocalDateTime.now();
    }
}
