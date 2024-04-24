package org.example.repository;

import org.example.entity.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class RepositoryClienteImpl implements IRepositorio <Cliente>{
    List<Cliente> clientes= new ArrayList<>();
    Scanner sc= new Scanner(System.in);
    @Override
    public void guaradar(Cliente objeto) {
        clientes.add(objeto);
    }

    @Override
    public void mostrar() {
        System.out.println("------------------------------Clientes------------------------------");
        for (Cliente cliente : clientes) {
            System.out.println("El cliente "+cliente.getNombre()+" "+cliente.getApellido()+" con el DNI "+cliente.getDni());
        }
    }

    @Override
    public Optional<Cliente> buscar(int id) {


        for (Cliente cliente : clientes) {
            if(cliente.getDni()==id){

                System.out.println("-----------El cliente "+
                        cliente.getNombre()+" "+
                        cliente.getApellido()+" con el DNI "+
                        cliente.getDni()+" fue encontrado-----------");
                return Optional.of(cliente);
            }
        }
        System.out.println("El cliente con el DNI "+id+" no fue encontrado");
        return Optional.empty();
    }

    @Override
    public void eliminar() {
        System.out.println("Escribe el DNI del cliente a borrar");
        String dni=sc.next();
        boolean existe=false;

        for (Cliente cliente : clientes) {
            if(cliente.getDni()==Integer.parseInt(dni)){
                clientes.remove(cliente);
                existe=true;
                break;
            }
        }

        if(existe){

            System.out.println("El cliente con el DNI: "+dni+" fue borrado.");
        }else{
            System.out.println("El cliente "+dni+" no existe");
        }

    }
    public Cliente buscarClienteParaFactura(int id) {
        for (Cliente cliente : clientes) {
            if(cliente.getDni()==id){
                return cliente;
            }
        }
        return null;
    }
    /*
    @Override
    public List<Cliente> listar() {
        return null;
    }*/


}
