package org.example.linktracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
@NoArgsConstructor
public class ResponseLinkTrackerDTO {
    private String link;
    private String password;

    public ResponseLinkTrackerDTO(String link) {
        this.link = link;
    }

    public ResponseLinkTrackerDTO(String link, String password) {
        this.link = link;
        this.password = password;
    }
}
