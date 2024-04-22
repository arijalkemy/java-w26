package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Link {

    private Long id;
    private String originalUrl;
    private String maskedUrl;
    private int redirectionCount;
    private String password;

}
