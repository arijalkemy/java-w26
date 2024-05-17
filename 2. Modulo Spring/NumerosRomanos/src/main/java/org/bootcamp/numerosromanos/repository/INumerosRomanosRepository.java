package org.bootcamp.numerosromanos.repository;

public interface INumerosRomanosRepository {
    String convertirNroDecimalARomano(Integer numeroDecimal);
    Integer convertirNroRomanoADecimal(String numeroRomano);
}
