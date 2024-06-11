package org.example;

/**
 * Una empresa de servicios de seguridad tiene 7 clientes que todos los meses abonan la cuota de dos posibles tipos de
 * servicio:
 * Servicio 1: Seguridad con cámaras - Precio Fijo de $1500 al mes
 * Servicio 2: Seguridad con cámaras + patrullaje - Precio de $1500 + $700 por el servicio de patrullaje
 * Dependiendo del tipo de servicio, se desea poder calcular el monto final de la factura para cada uno de los clientes.
 * Tener en cuenta, que existe un vector en donde se almacena el tipo de servicio que cada cliente adquirió.
 */
public class Ejercicio4 {
    public static void main(String[] args) {
        // Definir los tipos de servicios para cada cliente (7 clientes en total)
        int[] tipoDeServicio = {1, 2, 1, 2, 1, 1, 2};

        // array de clientes
        Cliente[] clientes = new Cliente[7];
        for (int i = 0; i < clientes.length; i++) {
            clientes[i] = new Cliente("Cliente" + (i + 1), tipoDeServicio[i]);
        }

        // Calcular y mostrar el monto final de la factura para cada cliente
        for (Cliente cliente : clientes) {
            double montoFinal = ServicioSeguridad.calcularMontoFinal(cliente);
            System.out.println("Monto final de la factura para " + cliente.getNombre() + ": $" + montoFinal);
        }
    }

    static class Cliente {
        private final String nombre;
        private final int tipoDeServicio;

        public Cliente(String nombre, int tipoDeServicio) {
            this.nombre = nombre;
            this.tipoDeServicio = tipoDeServicio;
        }

        public String getNombre() {
            return nombre;
        }

        public int getTipoDeServicio() {
            return tipoDeServicio;
        }
    }

    static class ServicioSeguridad {
        private static final double PRECIO_FIJO = 1500;
        private static final double PRECIO_PATRULLAJE = 700;

        public static double calcularMontoFinal(Cliente cliente) {
            double montoFinal = PRECIO_FIJO;
            if (cliente.getTipoDeServicio() == 2) {
                montoFinal += PRECIO_PATRULLAJE;
            }
            return montoFinal;
        }
    }
}
