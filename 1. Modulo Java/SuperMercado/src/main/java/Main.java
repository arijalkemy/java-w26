import modelo.Cliente;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Cliente nacho = new Cliente("Nacho", "Ruiz Diaz", "44080739");
        Cliente julieta = new Cliente("Julieta", "Ruiz Diaz", "44080740");
        Cliente felipe = new Cliente("Felipe", "Ruiz Diaz", "44080741");


        List<Cliente> clientes = new ArrayList<>(Arrays.asList(nacho,julieta,felipe));

        System.out.println("CLIENTES");
        for(Cliente cliente : clientes)
            System.out.println(cliente.toString());

        System.out.println();

        System.out.println("CLIENTES SIN FELIPE");
        clientes.remove(felipe);

        for(Cliente cliente : clientes)
            System.out.println(cliente.toString());

        Scanner teclado = new Scanner(System.in);

        System.out.println();
        System.out.println();

        while (true){
            System.out.println("Seleccione una opción");
            System.out.println("BUSCAR CLIENTE X DNI: 1");
            System.out.println("SALIR: 0");

            int opcion = teclado.nextInt();

            if(opcion == 0){
                return;
            } else {
                System.out.println("INGRESE EL DNI");
                String dniBuscado = teclado.next();

                Optional<Cliente> cliente = clientes.stream().filter(cl -> cl.getDni().equals(dniBuscado)).findAny();

                if(cliente.isPresent()){
                    System.out.println("Cliente encontrado: ");
                    System.out.println(cliente.get().toString());
                    System.out.println();
                } else {
                    System.out.println("Cliente no encontrado.");
                    System.out.println();
                }
            }
        }





    }
}
