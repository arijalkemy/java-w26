package bootcamp.spring.ej_numromanos.services;

import org.springframework.stereotype.Service;

import bootcamp.spring.ej_numromanos.utils.NumerosRomanos;

@Service
public class NumerosRomanosService {
    
    public String convertirNumero(Integer numero){
        if (numero < 1 || numero > 3999) {
            throw new IllegalArgumentException("El número debe estar entre 1 y 3999");
        }
        return NumerosRomanos.convertirDecimalARomano(numero);
    }
}
