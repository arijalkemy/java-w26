package org.example.linktracker.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@ToString
public class Link {
    private String id;
    private String url;
    private String password;
    private Integer countRedirect;

    public Link(String url){
        setId(UUID.randomUUID().toString());
        setUrl(url);
        setCountRedirect(0);
    }

    public Link(String url, String password){
        setId(UUID.randomUUID().toString());
        setUrl(url);
        setPassword(password);
        setCountRedirect(0);
    }
}
