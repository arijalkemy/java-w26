package org.example.spring_recap_link_tracker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkTrack {
    private String linkId;
    private String link;
    private Integer redirectCount;
    private Boolean enabled;
    private String password;
}
