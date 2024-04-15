package com.javabootcamp.primerproyectospring.services;

public interface ConverterServices {

    String enteroARomano(int number);

    String morseATexto(String codigoMorse);

    String textoAMorse(String texto);
}
