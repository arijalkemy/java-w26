package org.bootcamp.blog.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogEntryDTO {

    private int id;
    private String title;
    private String author;
    private Date date;

}
