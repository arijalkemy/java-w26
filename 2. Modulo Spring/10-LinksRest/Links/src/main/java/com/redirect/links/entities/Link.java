package com.redirect.links.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class Link {
    private String url;
    private String password;
    private boolean isValid = true;
    private Integer counter = 0;


    public Link(String url, String password){
        this.url = url;
        this.password = password;
    }
}
