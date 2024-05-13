package org.example.link_tracer.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Link {
    private Integer id;
    private String link;
    private String password;
    private Boolean enabled=true;
    private Integer usages=0;
}
