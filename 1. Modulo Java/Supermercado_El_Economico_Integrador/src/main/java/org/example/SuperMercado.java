package org.example;

import org.example.entidad.Cliente;
import org.example.entidad.Factura;
import org.example.repositorio.impl.IRepositorioCRUDImplCliente;
import org.example.repositorio.impl.IRepositorioCRUDImplFactura;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class SuperMercado {

    private IRepositorioCRUDImplCliente repoCliente;
    private IRepositorioCRUDImplFactura repoFactura;

    public SuperMercado(IRepositorioCRUDImplCliente repoCliente, IRepositorioCRUDImplFactura repoFactura) {
        this.repoCliente = repoCliente;
        this.repoFactura = repoFactura;
    }

    public void buscarClientePorConsola(){
        List<Cliente> clientes = repoCliente.encontrarTodos();
        Scanner scanner = new Scanner(System.in);
        System.out.println("INSERTE EL DNI DEL CLIENTE QUE DESEA BUSCAR");
        Long cliDni = scanner.nextLong();

        Optional<Cliente> clienteEncontrado = clientes.stream()
                .filter(e -> e.getDni().equals(cliDni))
                .findFirst();
        if(clienteEncontrado.isPresent()){
            System.out.println("CLIENTE ENCONTRADO: ");
            System.out.println(clienteEncontrado.get());
        }
        else{
            System.out.println("CLIENTE NO ENCONTRADO");
        }
    }
    public void realizarCompra(Factura factura){
        Cliente cliente = factura.getCliente();

        Optional<Cliente> clienteEncontrado = repoCliente.encontrar(cliente.getDni());
        if(clienteEncontrado.isPresent()){
            repoFactura.guardar(factura);
        }
        else{
            repoCliente.guardar(cliente);
            repoFactura.guardar(factura);
        }
    }

}
