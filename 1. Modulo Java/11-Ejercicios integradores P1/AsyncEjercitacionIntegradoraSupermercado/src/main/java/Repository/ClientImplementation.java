package Repository;

import Model.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class ClientImplementation implements CRUDRepository<Client> {
    List<Client> listOfClients = new ArrayList<Client>();

    @Override
    public void save(Client object) {
        listOfClients.add(object);
    }

    @Override
    public void showScreen() {
        for (Client client : listOfClients) {
            System.out.println("Dni: " + client.getDni());
            System.out.println("Nombre: " + client.getName());
            System.out.println("Apellido: " + client.getSurname());
        }
    }


    @Override
    public Optional<Client> loockFor(Long dniToLookFor) {
        boolean flag = false;
        for (Client client : listOfClients) {
            if (client.getDni().equals(dniToLookFor)) {
                System.out.println("---- Cliente encontrado, sus datos son: -----");
                System.out.println("Dni: " + client.getDni());
                System.out.println("Nombre:  " + client.getName());
                System.out.println("Apellido:  " + client.getSurname());
                return Optional.of(client);
            }
        }
        return Optional.empty();
    }

    @Override
    public void delete(Long dniToDelete) {
        Optional<Client> client = this.loockFor(dniToDelete);

        //Validar la funcion de eliminar cliente
        if (client.isEmpty()) {
            System.out.println("No se encontro el cliente a borrar");
        } else {
            System.out.println("El cliente fue eliminado con exito");
        }

        listOfClients.remove(client.get());
    }


    @Override
    public List<Client> getAll() {
        return listOfClients;
    }


}
