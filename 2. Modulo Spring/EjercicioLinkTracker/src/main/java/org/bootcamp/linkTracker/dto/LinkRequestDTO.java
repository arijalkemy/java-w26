package org.bootcamp.linkTracker.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LinkRequestDTO {
    private String publicUrl;
    private String password;
}
