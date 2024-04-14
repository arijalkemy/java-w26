package org.example.Model;

import java.util.List;
import java.util.Scanner;

public class Cliente {
        private String dni;
        private String nombre;
        private String apellido;

        public Cliente(String dni, String nombre, String apellido) {
                this.dni = dni;
                this.nombre = nombre;
                this.apellido = apellido;
        }

        @Override
        public String toString() {
                return "Cliente{" +
                        "dni='" + dni + '\'' +
                        ", nombre='" + nombre + '\'' +
                        ", apellido='" + apellido + '\'' +
                        "}";
        }

        public String getDni() {
                return dni;
        }

        public void setDni(String dni) {
                this.dni = dni;
        }

        public String getNombre() {
                return nombre;
        }

        public void setNombre(String nombre) {
                this.nombre = nombre;
        }

        public String getApellido() {
                return apellido;
        }

        public void setApellido(String apellido) {
                this.apellido = apellido;
        }

        public static Cliente consultaCliente(List<Cliente> clientes){
                Scanner searchDni = new Scanner(System.in);

                System.out.print("Que usuario estas Buscando: ");
                String dni= searchDni.nextLine();
                System.out.println(dni);

                Cliente cliente = clientes.stream().filter(p-> p.getDni().equals(dni)).findFirst().orElse(null);

                return cliente;

        }
}
