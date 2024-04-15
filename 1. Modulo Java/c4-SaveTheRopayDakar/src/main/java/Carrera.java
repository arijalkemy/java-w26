import java.util.List;

public class Carrera {
    private int distancia;
    private int premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> vehiculosAnotados;

    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public void darDeAltaAuto(int velocidad,int aceleracion,int AnguloDeGiro,String patente){
        if (vehiculosAnotados.size() < cantidadDeVehiculosPermitidos){
            vehiculosAnotados.add(new Auto(velocidad,aceleracion,AnguloDeGiro,patente));
        }

    }
    public void darDeAltaMoto(int velocidad,int aceleracion,int AnguloDeGiro, String patente){
        if (vehiculosAnotados.size() < cantidadDeVehiculosPermitidos){
            vehiculosAnotados.add(new Moto(velocidad,aceleracion,AnguloDeGiro,patente));
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        vehiculosAnotados.remove(vehiculo);
    }
    public void eliminarVehiculoConPatente(String patente){
        vehiculosAnotados.removeIf(vehiculo -> vehiculo.getPatente().equals(patente));
    }

    public void ganadorCarrera(){
        Vehiculo ganador = vehiculosAnotados.get(0);
        for (Vehiculo vehiculo: vehiculosAnotados){
            if (vehiculo.getVelocidad() * (vehiculo.getAceleracion() / 2) / (vehiculo.getAnguloDeGiro() * (vehiculo.getPeso() - vehiculo.getRuedas() * 100)) > ganador.getVelocidad() * (ganador.getAceleracion() / 2) / (ganador.getAnguloDeGiro() * (ganador.getPeso() - ganador.getRuedas() * 100))){
                ganador = vehiculo;
            }
        }
        System.out.println("El ganador de la carrera es: "+ganador.getPatente());
    }

    public void socorrerAuto(String patente){
        for (Vehiculo vehiculo: vehiculosAnotados){
            if (vehiculo.getPatente().equals(patente)){
                socorristaAuto.socorrer((Auto) vehiculo);
            }
        }
    }
    public void socorrerMoto(String patente){
        for (Vehiculo vehiculo: vehiculosAnotados){
            if (vehiculo.getPatente().equals(patente)){
                socorristaMoto.socorrer((Moto) vehiculo);
            }
        }
    }
}
