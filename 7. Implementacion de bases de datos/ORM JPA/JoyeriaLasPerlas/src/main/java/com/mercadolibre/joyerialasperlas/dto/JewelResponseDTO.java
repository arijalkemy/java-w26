package com.mercadolibre.joyerialasperlas.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class JewelResponseDTO extends JewelDTO implements Serializable {
    private Long id;
}
