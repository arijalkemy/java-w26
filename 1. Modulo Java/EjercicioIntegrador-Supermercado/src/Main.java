import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Cliente cliente1 = new Cliente("Rodrigo","Arguello","39946553");
        Cliente cliente2 = new Cliente("Jose","Garcia","45095884");
        Cliente cliente3 = new Cliente("Melina","Almada","33444331");

        List<Cliente> listClientes = new ArrayList<>();
        listClientes.add(cliente1);
        listClientes.add(cliente2);
        listClientes.add(cliente3);

        System.out.println("Imprimiendo primer lista");
        listClientes.stream().forEach( c -> System.out.printf(c.toString()));

        listClientes.stream().findFirst().ifPresent(listClientes::remove);

        System.out.println("Imprimiendo la lista con el cliente elminiado");
        listClientes.stream().forEach( c -> System.out.printf(c.toString()));

        int finalizar = 1;

        while (finalizar != 0){

            Scanner scanner = new Scanner(System.in);

            System.out.println("Ingrese el número de dni para buscar un cliente:");

                String dni = scanner.nextLine();


                var cliente = listClientes.stream().filter(c -> c.getDni().equals(dni)).findFirst();


                if(cliente.isPresent()){
                    System.out.println("Cliente encontrado!");
                    System.out.println(cliente.get().toString());
                }else{
                    System.out.println("No existe un cliente con el dni especificado");
                }
                System.out.println("-----------------------------------");
                System.out.println("Presione cualquier tecla para CONTINUAR o ingrese 0 para SALIR ");
                try{

                    finalizar = scanner.nextInt();
                }catch (Exception ex){

                }
            }

    }
}