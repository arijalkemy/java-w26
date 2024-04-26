package com.Ejercicio.CodigoMorse.Controller;
import com.Ejercicio.CodigoMorse.Service.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConverterController {

    @Autowired
    Convert convertImplementation;

    @GetMapping("convertToABC/{morseText}")
    public String convertToABC(@PathVariable String morseText){
        return convertImplementation.convertToABC(morseText);
    }

    @GetMapping("convertToMorse/{abcText}")
    public String convertToMorse(@PathVariable String abcText){
        return convertImplementation.convertToMorse(abcText);
    }

}

