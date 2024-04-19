package com.example.linkTracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Link {
    private String id;
    private boolean valid;
    private int accessCounter;
}
