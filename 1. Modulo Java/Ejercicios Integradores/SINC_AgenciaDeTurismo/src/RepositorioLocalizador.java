import java.util.ArrayList;
import java.util.List;

public class RepositorioLocalizador {
    private List<Localizador> listaLocalizadores;

    public RepositorioLocalizador() {
        this.listaLocalizadores = new ArrayList<>();
    }

    public List<Localizador> getListaLocalizadores() {
        return listaLocalizadores;
    }

    public void agregarLocalizadorARepositorio(Localizador localizador) {
        listaLocalizadores.add(localizador);
        if (clienteConMasdeDosLocalizadores(localizador.getCliente())) {
            localizador.setDescuento(0.05);
        }
        localizador.esPaqueteCompleto();
        localizador.tieneDosBoletosODosHotel();

    }

    public boolean clienteConMasdeDosLocalizadores(Cliente cliente){
        if (listaLocalizadores.stream().filter(x -> x.getCliente().equals(cliente)).count() >= 2) {
            return true;
        } else {
            return false;
        }
    }
}
