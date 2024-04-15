package Punto1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Analizador {
    private List<Localizador> localizadores;
    public Analizador(List<Localizador> localizadores) {
        this.localizadores = localizadores;
    }
    public int getCantidadLocalizadoresv(){
        return  localizadores.size();
    }
    public int getCatidadRevervas(){
        return localizadores.stream().mapToInt(localizador-> localizador.getReservas().size()).sum();
    }
    public Map<String, Integer> getReservasPorTipo(){
        Map<String, Integer> reservasPorTipo = new HashMap<>();
        for(Localizador localizador: localizadores){
            for(Reserva reserva: localizador.getReservas()){
                reservasPorTipo.merge(reserva.getDescripcion(), 1, Integer::sum);
            }
        }
        return reservasPorTipo;
    }
    public double getTotalDeVentas(){
        return localizadores.stream().mapToDouble(Localizador::getTotalConDescuento).sum();

    }
    public double getPromedioVentas(){
        return localizadores.stream().mapToDouble(Localizador::getTotalConDescuento).average().orElse(0.0);
    }
}
