package bootcamp.spring.morse.services;

import org.springframework.stereotype.Service;

import bootcamp.spring.morse.utils.TraductorMorse;

@Service
public class TraductorService {
    
    public String traducirEspanol(String fraseEspanol){
        return TraductorMorse.traducirEspañol(fraseEspanol);
    }

    public String traducirMorse(String codigoMorse){
        return TraductorMorse.traducirMorse(codigoMorse);
    }
}
