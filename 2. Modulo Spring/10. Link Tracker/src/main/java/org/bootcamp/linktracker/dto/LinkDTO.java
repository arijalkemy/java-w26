package org.bootcamp.linktracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LinkDTO {
    private Integer linkId;
    private String link;
    private String password;
    private Integer count;
}
