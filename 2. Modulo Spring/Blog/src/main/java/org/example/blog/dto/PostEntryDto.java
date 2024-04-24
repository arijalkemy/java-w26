package org.example.blog.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;

@Data
public class PostEntryDto implements Serializable {

    private int id;
    private String postName;
    private String authorName;
    private String publishedDate;
}
