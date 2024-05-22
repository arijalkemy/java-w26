package com.example.linktracker.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class LinkDTO {
    private Integer linkId;
    private String link;
    private String password;
    private Integer count;

    public LinkDTO() {
        this.count = 0;
    }
    public void sumCount() {
        count++;
    }
}
