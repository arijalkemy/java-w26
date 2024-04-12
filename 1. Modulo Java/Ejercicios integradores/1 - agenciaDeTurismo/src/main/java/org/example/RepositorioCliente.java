package org.example;
import java.util.List;
import java.util.Optional;

public interface RepositorioCliente {
    // Método para agregar un nuevo cliente al repositorio
    void agregarCliente(Cliente cliente);

    // Método para obtener un cliente por su ID
    Optional<Cliente> buscarCliente(int id);

    // Método para obtener todos los clientes
    List<Cliente> obtenerTodosLosClientes();

    // Método para obtener todos los localizadores de un cliente específico
    List<Localizador> obtenerLocalizadoresDelCliente(int clienteId);
}
