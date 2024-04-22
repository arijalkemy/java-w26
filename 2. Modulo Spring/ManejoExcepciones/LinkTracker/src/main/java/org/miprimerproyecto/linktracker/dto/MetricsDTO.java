package org.miprimerproyecto.linktracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MetricsDTO implements Serializable {
    private String linkId;
    private int redirectionCount;
}
