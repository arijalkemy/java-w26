import java.util.ArrayList;
import java.util.List;

public class Localizador {

    private List<ReservaHotel> listaReservaHoteles = new ArrayList<>();
    private List<Comida> listaComidas = new ArrayList<>();
    private List<BoletosViaje> listaBoletosViajes = new ArrayList<>();
    private List<Transporte> listaTransportes = new ArrayList<>();
    private Cliente  cliente ;

    public List<ReservaHotel> getListaReservaHoteles() {
        return listaReservaHoteles;
    }

    public void setListaReservaHoteles(List<ReservaHotel> listaReservaHoteles) {
        this.listaReservaHoteles = listaReservaHoteles;
    }

    public List<Comida> getListaComidas() {
        return listaComidas;
    }

    public void setListaComidas(List<Comida> listaComidas) {
        this.listaComidas = listaComidas;
    }

    public List<BoletosViaje> getListaBoletosViajes() {
        return listaBoletosViajes;
    }

    public void setListaBoletosViajes(List<BoletosViaje> listaBoletosViajes) {
        this.listaBoletosViajes = listaBoletosViajes;
    }

    public List<Transporte> getListaTransportes() {
        return listaTransportes;
    }

    public void setListaTransportes(List<Transporte> listaTransportes) {
        this.listaTransportes = listaTransportes;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Localizador(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "listaReservaHoteles=" + listaReservaHoteles +
                ", listaComidas=" + listaComidas +
                ", listaBoletosViajes=" + listaBoletosViajes +
                ", listaTransportes=" + listaTransportes +
                ", cliente=" + cliente +
                '}';
    }
}
