package org.responseentity.linktracker.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LinkEntity {
    private UUID id;
    private String source;
    private int numberOfRedirects;
    private Boolean status;
}
