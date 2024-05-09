package org.example.SocialMeli2.repository;

import org.example.SocialMeli2.entity.Customer;

import java.util.List;

/**
 * Interfaz para el repositorio de clientes.
 */
public interface ICustomerRepository {

    /**
     * Obtiene una lista de clientes que siguen a un vendedor específico.
     *
     * @param id El ID del vendedor.
     * @return Una lista de clientes que siguen al vendedor.
     */
    List<Customer> getCustomersThatFollowsSellersById(int id);

    /**
     * Busca un cliente por su ID.
     *
     * @param id El ID del cliente.
     * @return El cliente si se encuentra, o null si no se encuentra.
     */
    Customer findCustomerById(int id);

    /**
     * Permite a un usuario seguir a un cliente.
     *
     * @param userId El ID del usuario que quiere seguir al cliente.
     * @param userIdToFollow El ID del cliente a seguir.
     * @return Verdadero si el usuario pudo seguir al cliente, falso en caso contrario.
     */
    boolean userIdToFollowCustomer(int userId, int userIdToFollow);
}
