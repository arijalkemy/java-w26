import java.util.List;

public class Garage {
    private int idAuto = 1;
    private List<Vehiculo> ListaVehiculos;

    public Garage(List<Vehiculo> listaVehiculos) {
        ListaVehiculos = listaVehiculos;
    }

    public int getIdAuto() {
        return idAuto;
    }


    public List<Vehiculo> getListaVehiculos() {
        return ListaVehiculos;
    }

    public void setListaVehiculos(List<Vehiculo> listaVehiculos) {
        ListaVehiculos = listaVehiculos;
    }
}