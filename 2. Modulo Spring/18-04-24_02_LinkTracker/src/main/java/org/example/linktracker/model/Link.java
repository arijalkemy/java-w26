package org.example.linktracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Link {
    private Integer id;
    private String url;
    private String password;
    private boolean valid;
    private int redirectCount;
}
