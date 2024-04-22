package org.example.linktraker.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@NoArgsConstructor
public class LinkMetricasResponseDto implements Serializable {
    private int numeroRedirecciones;
}
