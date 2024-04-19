package org.example.linktracker.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LinkDTO {
    private String idLink;
    private String url;
    private Integer countRedirect;
}
