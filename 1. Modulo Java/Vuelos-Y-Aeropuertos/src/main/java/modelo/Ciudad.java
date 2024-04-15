package modelo;

import java.util.ArrayList;
import java.util.List;

public class Ciudad {
    private String nombre;
    private List<Aeropuerto> aeropuertos = new ArrayList<Aeropuerto>();

    public Ciudad(String nombre) {
        this.nombre = nombre;
    }

    public void agregarAeropuerto(Aeropuerto aeropuerto){
        this.aeropuertos.add(aeropuerto);
    }

    @Override
    public String toString(){
        return this.nombre;
    }

    public List<Aeropuerto> getAeropuertos() {
        return aeropuertos;
    }

    public void setAeropuertos(List<Aeropuerto> aeropuertos) {
        this.aeropuertos = aeropuertos;
    }
}
