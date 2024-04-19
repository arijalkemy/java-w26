package com.example.recapitulandospringp2vivo_linktracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class URLdto {
    private String id ;
    private String path;

    private Integer countOfTimesRedirect = 0;

    public URLdto(String path) {
        this.path = path;
    }
}
