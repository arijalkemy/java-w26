package com.bootcamp.c4blog.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BlogResponseDTO {
    private int id;

    public BlogResponseDTO(int id) {
        this.id = id;
    }
}
