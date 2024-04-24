package org.example.repository;

import org.example.entity.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class RepositoryItemsImpl implements IRepositorio<Item>{
    List<Item> items= new ArrayList<>();
    Scanner sc= new Scanner(System.in);
    @Override
    public void guaradar(Item objeto) {
        items.add(objeto);
    }


    @Override
    public void mostrar() {
        System.out.println("------------------------------Items------------------------------");
        for (Item item : items) {
            System.out.println(item.toString());
        }
    }

    @Override
    public Optional<Item> buscar(int id) {
        for (Item item : items) {
            if(item.getCodigo()==id){
                System.out.println("-----------El item "+ item.toString()+" fue encontrado-----------");
                return Optional.of(item);
            }
        }
        System.out.println("El item con el codigo "+id+" no fue encontrado");
        return Optional.empty();
    }

    @Override
    public void eliminar() {
        System.out.println("Escribe el codigo del item a borrar");
        String codigo=sc.next();
        boolean existe=false;

        for (Item item : items) {
            if(item.getCodigo()==Integer.parseInt(codigo)){
                items.remove(item);
                existe=true;
                break;
            }
        }

        if(existe){
            System.out.println("El item con el codigo: "+codigo+" fue borrado.");
        }else{
            System.out.println("El item con el codigo: "+codigo+" no fue encontrado.");
        }

    }
}
