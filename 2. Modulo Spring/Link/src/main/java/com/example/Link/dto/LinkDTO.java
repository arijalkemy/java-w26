package com.example.Link.dto;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class LinkDTO {
    private Integer id;
    private String url;
    private boolean isValid;
}
