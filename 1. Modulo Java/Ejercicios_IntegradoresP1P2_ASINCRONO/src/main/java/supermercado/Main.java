package supermercado;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        /*Parte 1
        ArrayList<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("Jesus","Nazareth","123131313"));
        clientes.add(new Cliente("Roberto","Lazayo","123231313"));
        clientes.add(new Cliente("Jesus","Ruiz","123131sAS3"));
        //Ver clientes
        for(Cliente cliente : clientes){
            System.out.println(cliente);
        }
        //Eliminar clientes
        clientes.removeIf(c->c.getDNI().equals("123231313"));
        //Ver clientes después de eliminar
        for(Cliente cliente : clientes){
            System.out.println(clientes);
        }
        //Buscar cliente por DNI
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite el ID del cliente a buscar: ");
        String id = scanner.nextLine();
        boolean encontrado = false;
        for(Cliente cliente : clientes){
            if(cliente.getDNI().equals(id)){
                System.out.println("Cliente encontrado" + cliente);
                encontrado = true;
                break;
            }
        }
        if(!encontrado){
            System.out.println("Cliente no encontrado");
        }*/
        /*Parte 2 y bono*/
        GestionClientes gestionClientes = new GestionClientes();
        gestionClientes.agregar(new Cliente("Jesus", "Nazareth","123131313"));
        gestionClientes.agregar(new Cliente("Roberto","Gomez","12112131"));

        /*Crear irems y factura*/
        List<Item> items = new ArrayList<>();
        items.add(new Item("Laptop", 1223121));
        items.add(new Item("Mouse",2131321));

        Cliente cliente = gestionClientes.buscar(new Cliente("Jesus","Nazareth","123131313"));
        if (cliente==null){
            System.out.println("====================================================================");
            System.out.println("Cliente no registrado, se creará");
            cliente = new Cliente("Jesus","Nazareth","123131313");
            gestionClientes.agregar(cliente);
        }
        Factura factura = new Factura(cliente, items);
        System.out.println("Factura creada: "+ factura);
    }
}
