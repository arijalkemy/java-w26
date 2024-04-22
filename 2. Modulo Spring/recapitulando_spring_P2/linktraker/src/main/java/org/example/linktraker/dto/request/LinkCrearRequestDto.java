package org.example.linktraker.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@NoArgsConstructor
public class LinkCrearRequestDto implements Serializable {
    private String url;
    private String password;
}
