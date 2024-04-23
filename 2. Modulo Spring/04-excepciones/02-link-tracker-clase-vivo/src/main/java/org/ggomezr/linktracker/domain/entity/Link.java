package org.ggomezr.linktracker.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Link {
    private String linkId;
    private String url;
    private String password;
    private int redirectionCount;
    private boolean valid;
}
