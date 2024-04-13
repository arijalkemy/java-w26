import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        //Parte 1
        Cliente cliente1 = new Cliente("Agos","adress 111",1);
        Cliente cliente2 = new Cliente("Agustin","adress 220",2);
        Cliente cliente3 = new Cliente("Pepito","adress 125",3);

        List<Cliente> clientes = new ArrayList<>();
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);
        //Parte 2
        System.out.println("Clientes: ");
        for (Cliente cliente : clientes){
            System.out.println("Nombre: " + cliente.getName() + " - Adress: " + cliente.getAdress());
        }
        //Parte 3
        clientes.remove(cliente2);
        System.out.println("Clientes: ");
        for (Cliente cliente : clientes){
            System.out.println("Nombre: " + cliente.getName() + " - Adress: " + cliente.getAdress());
        }
        //Parte 4
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresar nro de documento: ");
        int numero = scanner.nextInt();
        boolean encontrado = false;
        for (Cliente cliente : clientes){
            if (numero == cliente.getId()){
                System.out.println("Nombre: " + cliente.getName() + " - Adress: " + cliente.getAdress());
                encontrado = true;
            }
        }
        if (!encontrado) System.out.println("No se a encontrado dicho usuario.");
    }
}