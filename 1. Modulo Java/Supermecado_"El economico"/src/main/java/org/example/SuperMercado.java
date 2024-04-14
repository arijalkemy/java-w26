package org.example;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Clase SuperMercado que gestiona información sobre clientes, facturas y operaciones relacionadas.
 */
public class SuperMercado {
    private List<Cliente> clientes; // Lista de clientes del supermercado
    private List<Factura> facturas; // Lista de facturas del supermercado

    /**
     * Constructor de la clase SuperMercado que inicializa las listas de clientes y facturas.
     */
    public SuperMercado() {
        this.clientes = new ArrayList<>();
        this.facturas = new ArrayList<>();
    }

    /**
     * Método que imprime la lista de clientes del supermercado.
     */
    public void imprimirClientes(){
        this.clientes.forEach(System.out::println);
    }

    /**
     * Método que imprime la lista de facturas del supermercado.
     */
    public void imprimirFactura(){
        this.facturas.forEach(System.out::println);
    }

    /**
     * Método que elimina un cliente de la lista de clientes por nombre.
     * @param name Nombre del cliente a eliminar
     */
    public void eliminarCliente(String name){
        this.clientes = this.clientes.stream()
                .filter(e -> !Objects.equals(e.getNombre(), name))
                .collect(Collectors.toList());
    }

    /**
     * Método que busca un cliente en la lista por DNI.
     */
    public void buscarCliente(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el DNI del cliente que desea buscar");
        Integer userDni = scanner.nextInt();

        Optional<Cliente> clienteEncontrado = this.clientes.stream()
                .filter(e -> Objects.equals(e.getDni(), userDni))
                .findFirst();

        if(clienteEncontrado.isPresent()){
            System.out.println("Cliente encontrado: " + clienteEncontrado.get());
        }else{
            System.out.println("No se encontro el cliente");
        }
        scanner.close();
    }

    /**
     * Método que calcula el total de la lista de compras de productos.
     * @param productoList Lista de productos a calcular
     * @return Suma total de los productos
     */
    public double calcularTotalListaDeCompras(List<Producto> productoList){
        double sum = 0.0;
        for(Producto producto : productoList){
            sum = sum + (producto.getCantidad() * producto.getCostoUnitario());
        }
        return sum;
    }

    /**
     * Método que agrega un cliente a la lista de clientes del supermercado.
     * @param cliente Cliente a agregar
     */
    public void agregarCliente(Cliente cliente){
        this.clientes.add(cliente);
    }

    /**
     * Método que agrega una factura a la lista de facturas del supermercado.
     * @param factura Factura a agregar
     */
    public void agregarFactura(Factura factura){
        if(clientes.contains(factura.getCliente())){
            this.facturas.add(factura);
        } else{
            System.out.println("El cliente no se encuentra en la base de datos");
        }
    }

    /**
     * Método que devuelve la lista de clientes del supermercado.
     * @return Lista de clientes
     */
    public List<Cliente> getClientes() {
        return clientes;
    }

    /**
     * Método que devuelve la lista de facturas del supermercado.
     * @return Lista de facturas
     */
    public List<Factura> getFacturas() {
        return facturas;
    }
}
