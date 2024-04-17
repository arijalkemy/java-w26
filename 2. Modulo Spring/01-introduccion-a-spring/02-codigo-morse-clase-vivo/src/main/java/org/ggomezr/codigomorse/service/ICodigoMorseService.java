package org.ggomezr.codigomorse.service;

public interface ICodigoMorseService {
    String decodificarCodigoMorse(String mensaje);

    String codificarACodigoMorse(String mensaje);
}
