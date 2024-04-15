package codigomorse.servicios;

import org.springframework.stereotype.Service;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CodigoMorseServicio {
    private Map<String, String> tablaCodigoMorseAEspanol;

    private Map<String, String> tablaEspanolACodigoMorse;

    public CodigoMorseServicio() {
        this.tablaCodigoMorseAEspanol = Map.ofEntries(
                new AbstractMap.SimpleEntry<>(".-", "a"),
                new AbstractMap.SimpleEntry<>("-...", "b"),
                new AbstractMap.SimpleEntry<>("-.-.", "c"),
                new AbstractMap.SimpleEntry<>("-..", "d"),
                new AbstractMap.SimpleEntry<>(".", "e"),
                new AbstractMap.SimpleEntry<>("..-.", "f"),
                new AbstractMap.SimpleEntry<>("--.", "g"),
                new AbstractMap.SimpleEntry<>("....", "h"),
                new AbstractMap.SimpleEntry<>("..", "i"),
                new AbstractMap.SimpleEntry<>(".---", "j"),
                new AbstractMap.SimpleEntry<>("-.-", "k"),
                new AbstractMap.SimpleEntry<>(".-..", "l"),
                new AbstractMap.SimpleEntry<>("--", "m"),
                new AbstractMap.SimpleEntry<>("-.", "n"),
                new AbstractMap.SimpleEntry<>("---", "o"),
                new AbstractMap.SimpleEntry<>(".--.", "p"),
                new AbstractMap.SimpleEntry<>("--.-", "q"),
                new AbstractMap.SimpleEntry<>(".-.", "r"),
                new AbstractMap.SimpleEntry<>("...", "s"),
                new AbstractMap.SimpleEntry<>("-", "t"),
                new AbstractMap.SimpleEntry<>("..-", "u"),
                new AbstractMap.SimpleEntry<>("...-", "v"),
                new AbstractMap.SimpleEntry<>(".--", "w"),
                new AbstractMap.SimpleEntry<>("-..-", "x"),
                new AbstractMap.SimpleEntry<>("-.--", "y"),
                new AbstractMap.SimpleEntry<>("--..", "z"),
                new AbstractMap.SimpleEntry<>(".----", "1"),
                new AbstractMap.SimpleEntry<>("..---", "2"),
                new AbstractMap.SimpleEntry<>("...--", "3"),
                new AbstractMap.SimpleEntry<>("....-", "4"),
                new AbstractMap.SimpleEntry<>(".....", "5"),
                new AbstractMap.SimpleEntry<>("-....", "6"),
                new AbstractMap.SimpleEntry<>("--...", "7"),
                new AbstractMap.SimpleEntry<>("---..", "8"),
                new AbstractMap.SimpleEntry<>("----.", "9"),
                new AbstractMap.SimpleEntry<>("-----", "0"),
                new AbstractMap.SimpleEntry<>("..--..", "?"),
                new AbstractMap.SimpleEntry<>("-.-.--", "!"),
                new AbstractMap.SimpleEntry<>("--..--", ","),
                new AbstractMap.SimpleEntry<>(".-.-.-", ".")
        );
        this.tablaEspanolACodigoMorse = this.invertirMapa(this.tablaCodigoMorseAEspanol);
    }

    public String convertirOracionDeEspanolACodigoMorse(String oracion){
        List<String> palabras = List.of(oracion.split(" "));

        return palabras
                .stream()
                .map(this::convertirPalabraDeEspanolACodigoMorse)
                .collect(Collectors.joining("   "));
    }

    public String convertirPalabraDeEspanolACodigoMorse(String palabra){
        List<String> letras = List.of(palabra.split(""));
        return letras.stream().map(l -> this.tablaEspanolACodigoMorse.get(l)).collect(Collectors.joining(" "));
    }


    public String convertirOracionDeCodigoMorseAPalabra(String codigoMorse){
        List<String> palabrasEnCodigoMorse = List.of(codigoMorse.split("   "));

        return palabrasEnCodigoMorse
                .stream()
                .map(this::convertirPalabraDeCodigoMorseAPalabra)
                .collect(Collectors.joining(" "));
    }

    public String convertirPalabraDeCodigoMorseAPalabra(String palabraEnCodigoMorse){
        List<String> codigoMorse = List.of(palabraEnCodigoMorse.split(" "));

        return codigoMorse.stream().map(c -> this.tablaCodigoMorseAEspanol.get(c)).collect(Collectors.joining(""));
    }

    private  <K, V> Map<V, K> invertirMapa(Map<K, V> mapaOriginal) {
        Map<V, K> mapaInvertido = new HashMap<>();
        for (Map.Entry<K, V> entry : mapaOriginal.entrySet()) {
            mapaInvertido.put(entry.getValue(), entry.getKey());
        }
        return mapaInvertido;
    }
}
