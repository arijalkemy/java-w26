import java.util.ArrayList;
import java.util.List;


public class RepositorioLocalizador {
    private static List<Localizador> repoLocalizador = new ArrayList<>();

    public void agregarLocalizador(Localizador... localizadores){
        for (Localizador reserva : localizadores){
            repoLocalizador.add(reserva);
            }
    }


}
