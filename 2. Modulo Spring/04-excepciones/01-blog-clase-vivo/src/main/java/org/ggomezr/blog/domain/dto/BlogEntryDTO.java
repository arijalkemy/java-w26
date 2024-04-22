package org.ggomezr.blog.domain.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
public class BlogEntryDTO {
    private Integer id;
    private String blogTitle;
    private String authorName;

    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate publicationDate;

    private static Integer lastId = 0;

    public BlogEntryDTO() {
        this.id = ++lastId;
    }

    public BlogEntryDTO(String blogTitle, String authorName, LocalDate publicationDate) {
        this.id = ++lastId;
        this.blogTitle = blogTitle;
        this.authorName = authorName;
        this.publicationDate = publicationDate;
    }
}
