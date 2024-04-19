package com.example.multicapatemplate.dto;

import com.example.multicapatemplate.model.BlogEntry;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class BlogEntryDto {
    final private int id;
    final private String title;
    final private String authorName;
    final private LocalDate date;

    public BlogEntryDto(BlogEntry blogEntry) {
        this.id = blogEntry.getId();
        this.title = blogEntry.getTitle();
        this.authorName = blogEntry.getAuthorName();
        this.date = blogEntry.getDate();
    }
}
