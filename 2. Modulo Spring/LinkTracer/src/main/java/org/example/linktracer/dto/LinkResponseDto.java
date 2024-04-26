package org.example.linktracer.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.UUID;

@Data
public class LinkResponseDto {
    private UUID id;
    @JsonIgnore
    private int redirectCounter;
    @JsonIgnore
    private String password;
}
