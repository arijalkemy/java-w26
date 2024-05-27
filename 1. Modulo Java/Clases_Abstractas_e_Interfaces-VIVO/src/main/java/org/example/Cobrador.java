package org.example;

public class Cobrador implements Transaccion {

    // Clase Cobrador
        @Override
        public boolean transaccionOk() {
            System.out.println("Transacción exitosa para el Cobrador.");
            return true;
        }

        @Override
        public boolean transaccionNoOk() {
            System.out.println("Transacción fallida para el Cobrador.");
            return false;
        }
        // Método específico para retirar efectivo
        public void retirarEfectivo() {
            System.out.println("Retirando efectivo para el Cobrador.");
        }
        // Método específico para consultar saldo
        public void consultarSaldo() {
            System.out.println("Consultando saldo para el Cobrador.");
        }
    }
