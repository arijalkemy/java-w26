package org.miprimerproyecto.linktracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkDTO implements Serializable {
    private String linkId;
    private String originalUrl;
    private String password;
    private boolean isValid=true;
}
