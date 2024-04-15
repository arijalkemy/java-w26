import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String id;
    private List<Localizador> reservas;

    public Cliente(String id) {
        this.id = id;
        this.reservas = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void agregarReserva(Localizador reserva) {
        reservas.add(reserva);
    }

    public List<Localizador> getReservas() {
        return reservas;
    }
}

