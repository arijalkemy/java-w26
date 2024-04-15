import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nombre;
    private String apellido;
    private int dni;
    private List<Localizador> localizadoresCliente = new ArrayList<>();
    private boolean paqueteCompleto = false;
    private double totalCliente;

    public Cliente(String nombre, String apellido, int dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    public void agregarLocalizador(Localizador... localizadores){
        for (Localizador reserva : localizadores) {
            localizadoresCliente.add(reserva);
        }
    }

    public void setPaqueteCompleto(Localizador localizador){
        if(localizador.paqueteCompleto()){
            this.paqueteCompleto = true;
        }
    }

    public double getTotalCliente(){
        totalCliente = 0;
        int contadorLocalizadores = 0;
        for (Localizador localizador : localizadoresCliente){
            contadorLocalizadores += 1;
            if (contadorLocalizadores > 2){
                //si el cliente adquirio mas de dos localizadores, se comienza a aplicar el desc del 5 en futuras compras
                totalCliente = (localizador.getTotalReserva())*0.95;
            }else{
                totalCliente = localizador.getTotalReserva();
            }
        }
        if (paqueteCompleto){
            totalCliente *= 0.9;
        }
        return totalCliente;
    }

}
