package org.bootcamp.recapitulando_spring_p2_link_tracer.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
