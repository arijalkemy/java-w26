package org.practicaspring.links.dto;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class LinkRequestDTO implements Serializable {
    private String url;
}
