package org.example.linktraker.dto.response;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class LinkCrearResponseDto implements Serializable {
    int id;

    public LinkCrearResponseDto(int id) {
        this.id = id;
    }
}
