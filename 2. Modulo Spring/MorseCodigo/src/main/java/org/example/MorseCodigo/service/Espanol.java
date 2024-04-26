package org.example.MorseCodigo.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;

public class Espanol {
    private String codes;

    // El constructor debería ser público para poder ser utilizado fuera de la clase
    @JsonCreator
    public Espanol(@JsonProperty("code") String codes) {
        this.codes = codes;
    }

    // Visibilidad de getCodes a public para permitir el acceso si es necesario
    public String getCodes() {
        return codes;
    }

    //Visibilidad de setCodes a public para permitir el acceso
    @JsonProperty("code")
    public void setCodes(String codes) {
        this.codes = codes;
    }

    public String translateE(String text) {
        StringBuilder translationE = new StringBuilder();
        String upperText = text.toUpperCase(); // Convertir a mayúsculas para coincidir con las claves del mapa
        for (int i = 0; i < upperText.length(); i++) {
            char c = upperText.charAt(i);
            String espanolC = EspanolAlphabet.getReverseAlphabet().get(String.valueOf(c));
            if (espanolC != null) {
                translationE.append(espanolC).append(" ");
            } else {
                // Corregido el manejo de caracteres de espacio. 'c' es un char, por lo que se compara con ' ', no con " "
                if (c == ' ') {
                    translationE.append("   ");  // Tres espacios para simbolizar un espacio entre palabras en Morse
                } else {
                    translationE.append("? ");  // Agregado un espacio después de '?'
                }
            }
        }
        return translationE.toString().trim();
    }
}
