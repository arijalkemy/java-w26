package com.link.tracker.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
public class LinkDTO implements Serializable {

    private Integer linkId;
    private String link;
    private String password;
    private Integer count;

    public void sumCount() {
        count++;
    }
}
