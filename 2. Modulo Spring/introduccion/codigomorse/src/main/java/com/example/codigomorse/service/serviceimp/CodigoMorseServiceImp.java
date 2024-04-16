package com.example.codigomorse.service.serviceimp;

import com.example.codigomorse.service.ICodigoMorseService;
import com.example.codigomorse.util.codigomorse.TraductorCodigoMorseUtil;
import org.springframework.stereotype.Service;

@Service
public class CodigoMorseServiceImp implements ICodigoMorseService {

    @Override
    public String codigoMorseATexto(String codigoMorse) {
        return TraductorCodigoMorseUtil.codigoMorseATexto(codigoMorse);
    }

    @Override
    public String textoACodigoMorse(String texto) {
        return TraductorCodigoMorseUtil.textoACodigoMorse(texto);
    }
}
