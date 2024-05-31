package com.example.introduccion_a_springp2pg;

public interface IRomanService {
    ResponseDTO toNumber(String romanNumber);
    ResponseDTO toRoman(Integer number);
}
