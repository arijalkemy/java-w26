package org.example;

import java.util.*;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        Cliente clienteUno = new Cliente(12393494, "Juan", "Perez");
        Cliente clienteDos = new Cliente(39009482, "Pedro", "Pascal");
        Cliente clienteTres = new Cliente(47829282, "Carlos", "Rodriguez");

        List<Cliente> listaDeClientes = new ArrayList<>();
        listaDeClientes.add(clienteUno);
        listaDeClientes.add(clienteDos);
        listaDeClientes.add(clienteDos);


        for (Cliente cliente: listaDeClientes){
            System.out.println(cliente);
        }
        System.out.println("\n");
        listaDeClientes.remove(1);
        for (Cliente cliente: listaDeClientes){
            System.out.println(cliente);
        }

        System.out.println("\n");

        Scanner sc = new Scanner(System.in);
        System.out.println("ingrese un dni para buscar usuario");
        long userINput = sc.nextLong();

        Optional<Cliente> userEncontrado = listaDeClientes.stream().filter((cliente)-> userINput == cliente.getDni()).findFirst();
        if (userEncontrado.isPresent()){
            System.out.println("\n");
            System.out.println(userEncontrado.toString());
        }else{
            System.out.println("user no encontrado");
        }


        Item cocaCola = new Item(1,"Coca-cola", 10, 1600 );
        Item pepsi = new Item(2,"pepsi-cola", 4, 1500 );
        List<Item> listaDeItems = new ArrayList<>();
        listaDeItems.add(cocaCola);
        listaDeItems.add(pepsi);

        Factura facturaUno = new Factura(clienteUno, listaDeItems  );



    }
}
