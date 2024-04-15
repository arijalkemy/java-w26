package meli.bootcamp.AgenciaDeTurismo;

import java.util.*;

public class Repositorio {
    Map<Integer, List<Localizador>> historial = new HashMap<>();

    public Map<Integer, List<Localizador>> getHistorial() {
        return historial;
    }

    public void setHistorial(Map<Integer, List<Localizador>> historial) {
        this.historial = historial;
    }

    public void agregarLocalizador(Localizador localizador) {
        List<Localizador> localizadores = historial.get(localizador.getCliente().getId());

        if (localizadores == null) {
            List<Localizador> localizadorList = new ArrayList<>();
            localizadorList.add(localizador);
            historial.put(localizador.getCliente().getId(), localizadorList);
        } else {
            if(localizadores.size() > 2){
                localizador.setTotal(localizador.getTotal() * 0.95);
            }
            if(localizador.getReservas().stream().filter(r -> r.getTipoReserva().equals(TipoReserva.PAQUETE))
                    .findAny().orElse(null) != null){
                localizador.setTotal(localizador.getTotal() * 0.90);
            }

            long hotelesOViajes = Math.max(localizador.getReservas().stream().filter(l -> l.getTipoReserva().equals(TipoReserva.HOTEL)).count(),
                    localizador.getReservas().stream().filter(l -> l.getTipoReserva().equals(TipoReserva.VIAJE)).count());
            if(hotelesOViajes >= 2){
                localizador.setTotal(localizador.getTotal() * 0.95);
            }

            localizadores.add(localizador);
            historial.put(localizador.getCliente().getId(), localizadores);
        }
    }
}
