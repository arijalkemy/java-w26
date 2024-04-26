package org.example.linktracker.dto.out;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class LinkWithMetricsResponseDto extends LinkResponseDto {

    private int hitCount;

    public LinkWithMetricsResponseDto(String linkId, String targetUrl, int hitCount) {
        super(linkId, targetUrl);

        this.hitCount = hitCount;
    }
}
