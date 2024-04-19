package com.spring.linktracker.entity;

import lombok.Data;

@Data
public class Link {

    private Integer linkId;
    private String url;
    private String password;
    private Integer timesRedirected;
    private Boolean isValid;
    private static Integer linkIdCounter = 0;

    public Link(String url, String password, Integer timesRedirected, Boolean isValid) {
        this.linkId = Link.linkIdCounter++;
        this.url = url;
        this.password = password;
        this.timesRedirected = timesRedirected;
        this.isValid = isValid;
    }
}
