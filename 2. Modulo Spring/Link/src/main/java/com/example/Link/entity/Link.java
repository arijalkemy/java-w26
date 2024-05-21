package com.example.Link.entity;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Link {
    private Integer id;
    private String url;
    private boolean isValid;
    private int accessCount;
}
