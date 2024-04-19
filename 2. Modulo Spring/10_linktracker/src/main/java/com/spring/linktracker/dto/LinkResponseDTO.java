package com.spring.linktracker.dto;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class LinkResponseDTO implements Serializable {

    private Integer linkId;

    public LinkResponseDTO(Integer linkId) {
        this.linkId = linkId;
    }
}
