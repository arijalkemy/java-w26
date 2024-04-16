package com.demospring.numerosromanos.services;

public interface ICodigoMorse {
    String decodificar(String codigo);
    String codificar(String texto);
}
