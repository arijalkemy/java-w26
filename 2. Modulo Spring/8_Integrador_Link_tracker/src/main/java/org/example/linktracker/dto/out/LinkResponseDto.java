package org.example.linktracker.dto.out;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkResponseDto {
    private String linkId;
    private String targetUrl;
}
