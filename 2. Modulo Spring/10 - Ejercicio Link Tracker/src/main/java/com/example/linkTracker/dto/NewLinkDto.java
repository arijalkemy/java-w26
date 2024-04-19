package com.example.linkTracker.dto;

import com.example.linkTracker.model.Link;

public class NewLinkDto {
    String id;

    public NewLinkDto(Link link ) {
        this.id = link.getId();
    }
}
