package org.ejercicio.linktracker.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;

import java.util.UUID;

@Getter
public class LinkRequestDto {
    private String link;
    private String password;
}
