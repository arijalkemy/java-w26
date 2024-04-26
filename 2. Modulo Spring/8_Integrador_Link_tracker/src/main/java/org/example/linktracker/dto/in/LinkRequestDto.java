package org.example.linktracker.dto.in;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LinkRequestDto {
    private String targetUrl;
    private String password;
}
