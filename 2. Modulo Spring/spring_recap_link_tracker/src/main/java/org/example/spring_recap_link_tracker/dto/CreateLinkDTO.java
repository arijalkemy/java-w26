package org.example.spring_recap_link_tracker.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CreateLinkDTO implements Serializable {
    private String link;
    private String password;
}
