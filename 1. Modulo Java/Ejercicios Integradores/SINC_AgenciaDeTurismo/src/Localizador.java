import java.util.List;

public class Localizador {
    private Cliente cliente;
    private List<Reserva> reservas;
    private double montoTotal;
    private double montoConDescuento;
    private double descuento;

    public Localizador(Cliente cliente, List<Reserva> reservas) {
        this.cliente = cliente;
        this.reservas = reservas;
        this.montoTotal = reservas.stream().mapToDouble(reserva -> reserva.getMonto()).sum();
        this.montoConDescuento = montoTotal;
        this.descuento = 0;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public double getMontoConDescuento() {
        return montoConDescuento;
    }

    public void setMontoConDescuento(double montoConDescuento) {
        this.montoConDescuento = montoConDescuento;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public String imprimirDatosLocalizador(){
        //Para obtener un string separados por coma de la lista de reservas
        StringBuilder nombresReservas = new StringBuilder();

        for (Reserva reserva : reservas) {
            nombresReservas.append(reserva.getNombre()).append(", ");
        }
        if (!reservas.isEmpty()) {
            nombresReservas.delete(nombresReservas.length() - 2, nombresReservas.length());
        }
        String nombresSeparadosPorComa = nombresReservas.toString();

        //calculo el monto
        if (descuento != 0) {
            montoConDescuento = montoTotal * (1-descuento);
        }

        return "Cliente: " + cliente.getNombre() + " " + cliente.getApellido() + "\n" +
                "Reserva: " + nombresSeparadosPorComa + "\n" +
                "Monto: " + montoConDescuento;
    }

    public void esPaqueteCompleto() {
        boolean tieneHotel = false;
        boolean tieneBoleto = false;
        boolean tieneTransporte = false;
        boolean tieneComida = false;

        if (reservas.stream().filter(reserva -> reserva.getNombre().toUpperCase().contains("HOTEL")).count() != 0) {
            tieneHotel = true;
        }
        if (reservas.stream().filter(reserva -> reserva.getNombre().toUpperCase().contains("BOLETO")).count() != 0) {
            tieneBoleto = true;
        }
        if (reservas.stream().filter(reserva -> reserva.getNombre().toUpperCase().contains("TRANSPORTE")).count() != 0) {
            tieneTransporte = true;
        }
        if (reservas.stream().filter(reserva -> reserva.getNombre().toUpperCase().contains("COMIDA")).count() != 0) {
            tieneComida = true;
        }

        if (tieneHotel && tieneBoleto && tieneTransporte && tieneComida) {
            this.setDescuento(0.1);
        }
    }

    public void tieneDosBoletosODosHotel() {
        boolean tieneDosBoletos = false;
        boolean tieneDosHotel = false;

        if (reservas.stream().filter(reserva -> reserva.getNombre().toUpperCase().contains("HOTEL")).count() == 2) {
            tieneDosHotel = true;
        }
        if (reservas.stream().filter(reserva -> reserva.getNombre().toUpperCase().contains("BOLETO")).count() == 2) {
            tieneDosBoletos = true;
        }

        if (tieneDosBoletos || tieneDosHotel) {
            this.setDescuento(0.05);
        }
    }
}
