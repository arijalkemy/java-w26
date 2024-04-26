package org.example.linktracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Link {
    private String linkId;
    private String targetUrl;
    private int hitCount;
    private String password;
}
