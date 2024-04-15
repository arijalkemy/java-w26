public class Descuentos {
    public static final double DESCUENTO_2_LOCALIZADORES = 0.05;
    public static final double DESCUENTO_PAQUETE_COMPLETO = 0.10;
    public static final double DESCUENTO_2_RESERVAS = 0.05;

    public static double aplicarDescuento(Localizador localizador, Cliente cliente) {
        double descuento = 0;

        if (cliente.getReservas().size() >= 2) {
            descuento += localizador.getTotal() * DESCUENTO_2_LOCALIZADORES;
        }

        if (esPaqueteCompleto(localizador.getDetalles())) {
            descuento += localizador.getTotal() * DESCUENTO_PAQUETE_COMPLETO;
        }

        if (tiene2ReservasHotelBoletos(localizador.getDetalles())) {
            descuento += localizador.getTotal() * DESCUENTO_2_RESERVAS;
        }

        return descuento;
    }

    private static boolean esPaqueteCompleto(String detalles) {
        // Aquí implementarías la lógica para verificar si el detalle indica un paquete completo
        return detalles.contains("hotel") && detalles.contains("comida") && detalles.contains("boletos") && detalles.contains("transporte");
    }

    private static boolean tiene2ReservasHotelBoletos(String detalles) {
        // Aquí implementarías la lógica para verificar si hay al menos 2 reservas de hotel o boletos
        return detalles.contains("hotel") && detalles.contains("hotel") || detalles.contains("boletos") && detalles.contains("boletos");
    }
}

