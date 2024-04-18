package org.example.exceptions_p1_yt_blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.exceptions_p1_yt_blog.entity.Blog;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class BlogDTO implements Serializable {
    final private Integer id;
    final private String title;
    final private String authorName;
    final private LocalDate date;

    public BlogDTO(Blog blogEntry) {
        this.id = blogEntry.getId();
        this.title = blogEntry.getTitle();
        this.authorName = blogEntry.getAuthor();
        this.date = blogEntry.getCreatedDate();
    }
}
