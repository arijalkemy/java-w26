package org.example.linktraker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.linktraker.dto.request.LinkCrearRequestDto;

@Data
@AllArgsConstructor
public class LinkPersonalizado {
    private String url;
    private boolean linkValido = true;
    private int numeroRedirecciones = 0;
    private String password;

    public LinkPersonalizado(LinkCrearRequestDto link) {
        this.url = link.getUrl();
        this.password = link.getPassword();
    }
}


