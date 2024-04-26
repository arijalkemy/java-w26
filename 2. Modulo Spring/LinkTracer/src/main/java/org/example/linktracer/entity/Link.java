package org.example.linktracer.entity;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class Link {
    private UUID id;
    private int redirectCounter;
    private String password;
}
