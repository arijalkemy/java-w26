package org.practicaspring.links.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class Link {
    private static Long nextid = 1L;
    private Long id;
    private String URL;
    private String password;

    public Link(String URL, String password) {
        this.id = nextid;
        this.password = password;
        this.URL = URL;
        nextid++;
    }
}
