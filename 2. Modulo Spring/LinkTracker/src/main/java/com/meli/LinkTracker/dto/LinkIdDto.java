package com.meli.LinkTracker.dto;

import lombok.Data;

@Data
public class LinkIdDto {
    private String id;

    public LinkIdDto(String id) {
        this.id = id;
    }
}
