import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConsultasLocalizadores {
    private List<Localizador> localizadores;

    public ConsultasLocalizadores(List<Localizador> localizadores) {
        this.localizadores = localizadores;
    }

    public int cantidadLocalizadoresVendidos() {
        return localizadores.size();
    }

    public int cantidadTotalReservas() {
        int totalReservas = 0;
        for (Localizador localizador : localizadores) {
            totalReservas += obtenerCantidadReservas(localizador.getDetalles());
        }
        return totalReservas;
    }

    public Map<String, Integer> obtenerReservasPorTipo() {
        Map<String, Integer> reservasPorTipo = new HashMap<>();
        for (Localizador localizador : localizadores) {
            String[] tipos = localizador.getDetalles().split(",");
            for (String tipo : tipos) {
                tipo = tipo.trim();
                reservasPorTipo.put(tipo, reservasPorTipo.getOrDefault(tipo, 0) + 1);
            }
        }
        return reservasPorTipo;
    }

    public double totalVentas() {
        double totalVentas = 0;
        for (Localizador localizador : localizadores) {
            totalVentas += localizador.getTotal();
        }
        return totalVentas;
    }

    public double promedioVentas() {
        double totalVentas = totalVentas();
        int cantidadLocalizadores = cantidadLocalizadoresVendidos();
        if (cantidadLocalizadores == 0) {
            return 0;
        }
        return totalVentas / cantidadLocalizadores;
    }

    private int obtenerCantidadReservas(String detalles) {
        String[] tipos = detalles.split(",");
        return tipos.length;
    }
}
