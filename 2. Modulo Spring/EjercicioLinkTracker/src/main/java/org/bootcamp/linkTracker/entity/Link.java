package org.bootcamp.linkTracker.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Link {
    private String publicUrl;
    private String linkId;
    private String password;
    private Integer timesVisited;

    public Link(String publicUrl, String password) {
        this.publicUrl = publicUrl;
        this.password = password;
        this.linkId = UUID.randomUUID().toString();
        this.timesVisited = 0;
    }
}
