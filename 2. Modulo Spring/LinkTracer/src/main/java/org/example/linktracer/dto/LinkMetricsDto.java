package org.example.linktracer.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.UUID;
@Data
public class LinkMetricsDto {
    @JsonIgnore
    private UUID id;
    private int redirectCounter;
    @JsonIgnore
    private String password;
}
