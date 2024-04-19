package org.example.spring_recap_link_tracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvalidateLinkDTO implements Serializable {
    private String linkId;
    private String message;
}
