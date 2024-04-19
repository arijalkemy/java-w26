package org.example.spring_recap_link_tracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class LinkResponseDTO implements Serializable {
    private String linkId;
}
