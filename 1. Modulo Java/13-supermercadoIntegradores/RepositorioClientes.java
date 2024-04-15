import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RepositorioClientes {
    /**
     * cumple la funcion de almacenar y se hace cargo de las responsabilidades inherentes a un repositorio de clientes.
     */
    private static Map<Integer, String> collectionClientes = new HashMap<>();

    public void agregarCliente(Cliente... clientes){
        for (Cliente cliente : clientes){
            collectionClientes.put(cliente.getDni(), cliente.getNombreApellido());
        }
    }

    public void mostarClientes(){
        for (Map.Entry<Integer, String> entrada : collectionClientes.entrySet()){
            System.out.println("Nombre cliente: " + entrada.getValue() + ". DNI: " + entrada.getKey());
        }
    }

    public void eliminarCliente(int clave){
        collectionClientes.remove(clave);
    }

    public boolean chequeoCliente(int documento){
        String dato = collectionClientes.get(documento);
        if (dato == null){
            return false;

        }else{
            return true;
        }
    }

    public void busquedaManual(){
        Scanner teclado = new Scanner(System.in);

        System.out.println("Por favor ingresar un numero de documento: ");
        int documento = teclado.nextInt();

        String dato = collectionClientes.get(documento);

        if (dato == null){
            System.out.println("No se encuentra el cliente en la base de datos.");
        }else{
            System.out.println(("Nombre del cliente: " + dato + ". Documento: " + documento));
        }
        teclado.close();
    }
}
