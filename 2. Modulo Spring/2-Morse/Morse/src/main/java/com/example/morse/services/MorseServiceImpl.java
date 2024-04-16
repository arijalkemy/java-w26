package com.example.morse.services;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MorseServiceImpl implements IMorseService{
    @Override
    public String traducirUnaPalabraMorse(String codigoMorse) {
        String[] letrasMorse = codigoMorse.split(" ");
        String codigoTraducido = "";
        /*for(int i = 0; i<letrasMorse.length; i++){
            for(Map.Entry<String, String> entry : simbolos.entrySet()){
                String primerLetra = letrasMorse[i];
                if(primerLetra.equals(entry.getKey())){
                    String unaLetra = entry.getValue();
                    codigoTraducido +=unaLetra;
                }
            }
        }*/
        for(int i = 0; i<letrasMorse.length; i++){
            if(simbolos.containsKey(letrasMorse[i])){
                codigoTraducido = codigoTraducido.concat(simbolos.get(letrasMorse[i]));
            }
        }
        return codigoTraducido;
    }

    @Override
    public String traducirFraseMorse(String codigoMorse) throws Exception {
        String[] palabrasMorse = codigoMorse.split("   ");
        String codigoTraducido = "";
        for(int i=0; i<palabrasMorse.length; i++){
            String[] letrasMorse = palabrasMorse[i].split(" ");
            for(int j = 0; j<letrasMorse.length; j++){
                if(simbolos.containsKey(letrasMorse[j])){
                    codigoTraducido = codigoTraducido.concat(simbolos.get(letrasMorse[j]));
                } else {
                    throw new Exception("El código proporcionado posee un error");
                }
            }
            codigoTraducido = codigoTraducido.concat(" ");
        }
        return codigoTraducido;
    }
}
