package org.example.repository;

import org.example.entity.Cliente;
import org.example.entity.Factura;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class RepositoryFacturaImpl implements IRepositorio <Factura>{
    List<Factura> facturas= new ArrayList<>();
    Scanner sc= new Scanner(System.in);
    @Override
    public void guaradar(Factura objeto) {

        facturas.add(objeto);
        System.out.println("La factura "+objeto.toString()+" fue guardada.");
    }

    @Override
    public void mostrar() {
        System.out.println("------------------------------Facturas------------------------------");
        for (Factura factura : facturas) {
            System.out.println("La factura "+factura.toString());
        }

    }

    @Override
    public Optional<Factura> buscar(int id) {
        for (Factura factura : facturas) {
            if(factura.getCodigo()==id){
                System.out.println("-----------La factura fue encontreada "+ factura.toString()+"-----------");
                return Optional.of(factura);
            }
        }
        return Optional.empty();
    }

    @Override
    public void eliminar() {
        System.out.println("Escriba el codigo de la factura a borrar:");

        String codigo=sc.next();
        boolean existe=false;

        for (Factura factura : facturas) {
            if(factura.getCodigo()==Integer.parseInt(codigo)){
                facturas.remove(factura);
                existe=true;
                break;
            }
        }

        if(existe){
            System.out.println("La factura con el codigo: "+codigo+" fue borrada.");
        }else{
            System.out.println("La factura con el codigo: "+codigo+" no fue encontrada.");
        }

    }
}
