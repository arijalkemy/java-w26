package com.javabootcamp.linktracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Link {
    int linkId;
    int redirectionCounter;
    String url;
    boolean active;
    String password;
}
