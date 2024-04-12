package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Supermercado {
    private List<Cliente> clientes;
    private List<Factura> facturas;

    public Supermercado() {
        this.clientes = new ArrayList<Cliente>();
        this.facturas = new ArrayList<Factura>();
    }

    public void cargarFactura(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el DNI del cliente: ");
        int dni = scanner.nextInt();
        Optional<Cliente> busqueda = this.buscarPorDNI(dni);
        Cliente cliente;
        if (!busqueda.isPresent()){
            System.out.println("El cliente no se encuentra registrado.");
            System.out.println("Ingrese nombre: ");
            String nombre = scanner.next();
            System.out.println("Ingrese apellido: ");
            String apellido = scanner.next();
            cliente = new Cliente(dni,nombre,apellido);
            this.clientes.add(cliente);
        } else {
            cliente = busqueda.get();
        }
        Factura nuevaFactura = new Factura(cliente);
        this.facturas.add(nuevaFactura);

    }

    public Optional<Cliente> buscarPorDNI(int dni){
        return this.clientes.stream().filter( c -> c.getDni() == dni).findFirst();
    }

    public void imprimirPorDNI(int dni){
        Optional<Cliente> cliente = this.buscarPorDNI(dni);
        if (cliente.isPresent()) {
            System.out.println(cliente.toString());
        } else {
            System.out.println("No se encuentra el cliente con DNI = " + dni);
        }
    }

    public void imprimirClientes(){
        this.clientes.forEach(c -> System.out.println(c.toString()) );
    }

    public void agregar(Cliente cliente){
        this.clientes.add(cliente);
    }

    public void agregar(Factura factura){
        this.facturas.add(factura);
    }

    public void eliminar(Cliente cliente){
        boolean eliminado = this.clientes.remove(cliente);
        if (eliminado) {
            System.out.println("Eliminado correctamente.");
        } else {
            System.out.println("No se encuentra el cliente.");
        }
    }
}
