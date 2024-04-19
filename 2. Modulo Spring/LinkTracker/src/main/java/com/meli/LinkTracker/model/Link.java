package com.meli.LinkTracker.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Link {
    private String id;
    private String url;
    private Integer countRedirect;

    public Link(String url) {
        this.id = UUID.randomUUID().toString();
        this.url = url;
    }

    public void incrementCount(){
        countRedirect++;
    }
}
