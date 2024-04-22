package org.example.linktraker.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@NoArgsConstructor
public class ValidarLinkRequestDto implements Serializable {
    private boolean validar;
}
