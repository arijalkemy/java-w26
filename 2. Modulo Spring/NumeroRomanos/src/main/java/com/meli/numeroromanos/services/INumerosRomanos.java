package com.meli.numeroromanos.services;

import org.springframework.stereotype.Service;
public interface INumerosRomanos {
    String encode (int numero);
    String decode (int numero);
}
