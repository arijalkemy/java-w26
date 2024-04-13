import java.util.HashMap;
import java.util.Map;

public class RepositorioLocalizadores {
    private Map<String, Localizador> localizadores;

    public RepositorioLocalizadores() {
        localizadores = new HashMap<>();
    }

    public void agregarLocalizador(Localizador localizador) {
        localizadores.put(localizador.getCliente().getNombre(), localizador);
        localizador.getCliente().incrementarCantidadLocalizadores();
    }

    public Localizador obtenerLocalizador(String nombreCliente) {
        return localizadores.get(nombreCliente);
    }
}