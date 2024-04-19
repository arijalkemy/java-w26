package com.mercadolibre.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BlogEntryRequest {
    private Integer id;
    private String title;
    private String authorName;
}
