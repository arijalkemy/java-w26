package com.w26.morse.morse.servicio;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.w26.morse.morse.MorseApplication;
import com.w26.morse.morse.config.DiccionarioMorse;
import lombok.extern.java.Log;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.HashMap;

@Log
public abstract class MorseServicio {
    private static DiccionarioMorse diccionario;
    public static String decodificar(String codigoMorse){
        String decodificado = "";
        String palabraMorse = "";

        int espacios = 0;
        for (char caracter: codigoMorse.toCharArray()) {
            if (caracter != ' ') {
                palabraMorse = palabraMorse + caracter;
                espacios = 0;
            }
            if (caracter == ' ')
            {
                if (palabraMorse.length() != 0) {
                    decodificado = decodificado + diccionario.getMapaMorseAlfabeto().get(palabraMorse);
                    palabraMorse = "";
                }
                espacios += 1;
            }

            if (espacios == 3) {
                decodificado = decodificado + " ";
                espacios = 0;
            }
        }
        decodificado = decodificado + diccionario.getMapaMorseAlfabeto().get(palabraMorse);
        return decodificado;
    }

    public static String codificar(String oracion)
    {
        String codificada = "";
        oracion = oracion.toUpperCase();
        for (char key: oracion.toCharArray()) {
            log.info("VALUE: " + diccionario.getMapaAlfabetoMorse().get(key));
            String palabraMorse = diccionario.getMapaAlfabetoMorse().get(key);

            if (palabraMorse == "   ") {
                codificada += diccionario.getMapaAlfabetoMorse().get(key);
            }
            codificada += diccionario.getMapaAlfabetoMorse().get(key) + " ";
        }
       return codificada;
    }
    public static void cargarMapa() throws IOException {
        if (diccionario == null)
        {
            Resource recursoDiccionarioMorse = new ClassPathResource("/static/diccionario_morse.json");
            String json = new String(Files.readAllBytes(Paths.get(recursoDiccionarioMorse.getURI())));
            ObjectMapper mapeador = new ObjectMapper();
            DiccionarioMorse diccionarioMorse = mapeador.readValue(json, DiccionarioMorse.class);
            MorseServicio.diccionario = diccionarioMorse;
        }

    }

}
