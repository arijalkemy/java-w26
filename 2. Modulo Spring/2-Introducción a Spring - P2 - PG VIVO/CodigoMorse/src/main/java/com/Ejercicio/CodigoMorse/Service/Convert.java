package com.Ejercicio.CodigoMorse.Service;

import org.springframework.stereotype.Component;

@Component
public interface Convert {
    String convertToABC(String morse);
    String  convertToMorse(String abcText);
}
