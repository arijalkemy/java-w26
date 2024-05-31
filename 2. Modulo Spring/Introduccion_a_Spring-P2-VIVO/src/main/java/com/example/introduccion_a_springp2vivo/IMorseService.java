package com.example.introduccion_a_springp2vivo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface IMorseService {

    ResponseDTO toMorse(String words);

    ResponseDTO toChars(String morse);
}
