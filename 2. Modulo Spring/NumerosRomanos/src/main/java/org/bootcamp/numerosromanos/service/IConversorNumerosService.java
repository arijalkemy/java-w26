package org.bootcamp.numerosromanos.service;

public interface IConversorNumerosService {
    String convertirNroDecimalARomano(Integer numeroDecimal);
    Integer convertirNroRomanoADecimal(String numeroRomano);
}
