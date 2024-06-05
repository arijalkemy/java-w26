package org.decodificador.ejercicio2_introduccion_spring_boot_p2_vivo_decodificador.servicios;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.HashMap;

@Service
public class CodificacionMorse implements ICodificacion {
    //Atributos de la clase
    private static final Map<String, String> mapMorse = new HashMap<>();
    private static final Map<String, String> mapDecodificado = new HashMap<>();
    // Bloque estático para inicializar el mapa
    // Mapeo de caracteres a código Morse
    static {
        mapMorse.put("A",".-");
        mapMorse.put("B","-...");
        mapMorse.put("C","-.-.");
        mapMorse.put("D","-..");
        mapMorse.put("E",".");
        mapMorse.put("F","..-.");
        mapMorse.put("G","--.");
        mapMorse.put("H","....");
        mapMorse.put("I","..");
        mapMorse.put("J",".---");
        mapMorse.put("K","-.-");
        mapMorse.put("L",".-..");
        mapMorse.put("M","--");
        mapMorse.put("N","-.");
        mapMorse.put("O","---");
        mapMorse.put("P",".--.");
        mapMorse.put("Q","--.-");
        mapMorse.put("R",".-.");
        mapMorse.put("S","...");
        mapMorse.put("T","-");
        mapMorse.put("U","..-");
        mapMorse.put("V","...-");
        mapMorse.put("W",".--");
        mapMorse.put("X","-..-");
        mapMorse.put("Y","-.--");
        mapMorse.put("Z","--..");
        mapMorse.put("0","-----");
        mapMorse.put("1",".----");
        mapMorse.put("2","..---");
        mapMorse.put("3","...--");
        mapMorse.put("4","....-");
        mapMorse.put("5",".....");
        mapMorse.put("6","-....");
        mapMorse.put("7","--...");
        mapMorse.put("8","---..");
        mapMorse.put("9","----.");
        
        //-------------------------
        mapDecodificado.put(".-", "A");
        mapDecodificado.put("-...", "B");
        mapDecodificado.put("-.-.", "C");
        mapDecodificado.put("-..", "D");
        mapDecodificado.put(".", "E");
        mapDecodificado.put("..-.", "F");
        mapDecodificado.put("--.", "G");
        mapDecodificado.put("....", "H");
        mapDecodificado.put("..", "I");
        mapDecodificado.put(".---", "J");
        mapDecodificado.put("-.-", "K");
        mapDecodificado.put(".-..", "L");
        mapDecodificado.put("--", "M");
        mapDecodificado.put("-.", "N");
        mapDecodificado.put("---", "O");
        mapDecodificado.put(".--.", "P");
        mapDecodificado.put("--.-", "Q");
        mapDecodificado.put(".-.", "R");
        mapDecodificado.put("...", "S");
        mapDecodificado.put("-", "T");
        mapDecodificado.put("..-", "U");
        mapDecodificado.put("...-", "V");
        mapDecodificado.put(".--", "W");
        mapDecodificado.put("-..-", "X");
        mapDecodificado.put("-.--", "Y");
        mapDecodificado.put("--..", "Z");
        mapDecodificado.put("-----", "0");
        mapDecodificado.put(".----", "1");
        mapDecodificado.put("..---", "2");
        mapDecodificado.put("...--", "3");
        mapDecodificado.put("....-", "4");
        mapDecodificado.put(".....", "5");
        mapDecodificado.put("-....", "6");
        mapDecodificado.put("--...", "7");
        mapDecodificado.put("---..", "8");
        mapDecodificado.put("----.", "9");
    }
    //Constructor
    public CodificacionMorse() {
    }

    //Recibe mensaje en plano y convierte en codigo morse
    @Override
    public String codificarMensaje(String mensaje){
        String codificarMensaje = "";
        //Dividir mensaje en palabras
        mensaje = mensaje.toUpperCase();
        String palabras[] = mensaje.split(" ");
        for(int j=0; j< palabras.length; j++){
            //Asignar cada palabra
            String letras = palabras[j];
            for(int l=0; l < letras.length(); l++){
                //Codifica mensaje
                codificarMensaje = codificarMensaje + mapMorse.get(letras.charAt(l)+"") +" ";
            }
            codificarMensaje = codificarMensaje + "  ";
        }
        return codificarMensaje;
    }
    @Override
    public String decodificarMensaje(String mensaje){
        String decodificarMensaje = "";
        //Dividir mensaje en palabras
        String palabras[] = mensaje.split("   ");
        for(int j=0; j< palabras.length; j++){
            String palabra = palabras[j];
            //Asignar cada palabra
            String letras[] = palabra.split(" ");
            for(int l=0; l < letras.length; l++){
                //Decodifica mensaje
                decodificarMensaje = decodificarMensaje + mapDecodificado.get(letras[l]);
            }
            decodificarMensaje = decodificarMensaje + " ";
        }
        return decodificarMensaje;
    }



}
