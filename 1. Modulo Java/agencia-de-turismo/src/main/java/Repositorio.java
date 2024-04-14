import java.util.*;
import java.util.stream.Collectors;

public class Repositorio {
    private List<Localizador> localizadores;
    private static double descuentoFuturo;

    public Repositorio() {
        this.localizadores = new ArrayList<>();
    }

    public List<Localizador> getLocalizadores() {
        return localizadores;
    }

    public void agregarLocalizador(Localizador localizador) {
        this.localizadores.add(localizador);
        this.comproDosHotelesODosBoletos();
        comproDosLocalizadores();
    }

    private void comproDosLocalizadores() {
        if (this.localizadores.size() >= 2 && descuentoFuturo == 0) {
            descuentoFuturo = 0.05;
        }
    }

    public boolean comproDosHotelesODosBoletos() {
        //fijarse si hay mas de dos hoteles o dos boletos
        long hoteles = this.getLocalizadores().stream()
                .flatMap(l -> l.getReservas().stream()) // Obtener todas las reservas
                .filter(r -> r.getTipoReserva().equals("hotel")) // Filtrar reservas de hotel
                .count();


        long boletos = this.getLocalizadores().stream()
                .flatMap(l -> l.getReservas().stream())
                .filter(r -> r.getTipoReserva().equals("hotel"))
                .count();

        boolean hayDosHoteles = false;
        boolean hayDosBoletos = false;

        if (hoteles >= 2) {
            hayDosHoteles = true;
        }
        if (boletos >= 2) {
            hayDosBoletos = true;
        }

        if (hayDosHoteles || hayDosBoletos) {
            aplicarDescuento(0.05);
            return true;
        } else {
            return false;
        }

    }

    private void aplicarDescuento(double descuento) {
        this.getLocalizadores().forEach(loc -> {
            loc.getReservas().forEach(reserva -> {
                double precioConDescuento = reserva.getPrecio() * (1 - descuento); // Iterar sobre las reservas y aplicar el descuento
                reserva.setPrecio(precioConDescuento);
                loc.setTotal(loc.getTotal());
            });
        });


    }

    @Override
    public String toString() {
        return "Repositorio{" +
                "localizadores=" + localizadores +
                '}';
    }


    public int obtenerTotalLocalizadores() {
        return this.getLocalizadores().size();
    }

    public int obtenerTotalReservas() {
        return this.getLocalizadores().stream()
                .mapToInt(l -> l.getReservas().size()).sum();
    }

    public Map<String, List<Reserva>> obtenerReservasClasificadasPorTipo() {
        return this.getLocalizadores().stream()
                .flatMap(l -> l.getReservas().stream())
                .collect(Collectors.groupingBy(Reserva::getTipoReserva));
    }

    public double obtenerTotalVentas() {
        return this.getLocalizadores().stream()
                .flatMap(l -> l.getReservas().stream())
                .mapToDouble(r->r.getPrecio()).sum();
    }
    public double obtenerPromedioVentas() {
        return this.getLocalizadores().stream()
                .flatMap(l -> l.getReservas().stream())
                .mapToDouble(r->r.getPrecio()).average().orElse(0.0);
    }
}

