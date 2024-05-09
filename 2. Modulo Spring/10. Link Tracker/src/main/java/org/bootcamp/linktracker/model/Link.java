package org.bootcamp.linktracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Link {
    private Integer linkId;
    private String link;
    private String password;
    private Integer count;
}
