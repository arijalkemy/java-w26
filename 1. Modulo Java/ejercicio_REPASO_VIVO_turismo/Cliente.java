class Cliente {
    private String nombre;
    private String direccion;
    private int cantidadLocalizadores;

    private Localizador localizador;

    public Cliente(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.cantidadLocalizadores = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getCantidadLocalizadores() {
        return cantidadLocalizadores;
    }

    public void incrementarCantidadLocalizadores() {
        cantidadLocalizadores++;
    }

    public double aplicarDescuentos(double total, Localizador localizadores) {
        double descuento = 0.0;

        // Descuento del 5% si el cliente ha adquirido al menos 2 localizadores anteriormente
        if (localizadores.size() >= 2) {
            descuento += total * 0.05;
        }

        // Descuento del 10% si el paquete incluye reserva de hotel, comida, boletos de viajes y transporte
        boolean paqueteCompleto = true;
        for (Localizador localizador : localizadores) {
            if (!localizador.contieneReserva("Hotel") || !localizador.contieneReserva("Comida") ||
                    !localizador.contieneReserva("Boleto de Viaje") || !localizador.contieneReserva("Transporte")) {
                paqueteCompleto = false;
                break;
            }
        }
        if (paqueteCompleto) {
            descuento += total * 0.10;
        }

        // Descuento del 5% en reservas de hotel o boletos de viaje si hay al menos 2
        int contadorHotel = 0;
        int contadorBoletos = 0;
        for (Localizador localizador : localizadores) {
            for (Reserva reserva : localizador.getReservas()) {
                if (reserva.getTipo().equals("Hotel")) {
                    contadorHotel++;
                } else if (reserva.getTipo().equals("Boleto de Viaje")) {
                    contadorBoletos++;
                }
            }
        }
        if (contadorHotel >= 2) {
            descuento += total * 0.05;
        }
        if (contadorBoletos >= 2) {
            descuento += total * 0.05;
        }

        return total - descuento;
    }
}