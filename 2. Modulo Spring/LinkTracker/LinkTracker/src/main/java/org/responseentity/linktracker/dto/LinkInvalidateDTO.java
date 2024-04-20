package org.responseentity.linktracker.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LinkInvalidateDTO {
    private UUID id;
    private String source;
    private String message;
}
