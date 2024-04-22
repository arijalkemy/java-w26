package com.example.linkTracker.dto;

import com.example.linkTracker.model.Link;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class NewLinkDto {
    String id;

    public NewLinkDto(Link link ) {
        this.id = link.getId();
    }
}
