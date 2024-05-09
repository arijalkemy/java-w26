package org.example.SocialMeli2.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.SocialMeli2.entity.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementación del repositorio de clientes.
 */
@Repository
public class CustomerRepository implements ICustomerRepository {
    private static List<Customer> customersList = new ArrayList<>();

    /**
     * Constructor que carga los clientes desde un archivo JSON.
     *
     * @throws IOException si hay un error al leer el archivo.
     */
    public CustomerRepository() throws IOException {
        loadCustomers();
    }

    /**
     * Carga los clientes desde un archivo JSON.
     *
     * @throws IOException si hay un error al leer el archivo.
     */
    private void loadCustomers() throws IOException {
        File file = ResourceUtils.getFile("classpath:customers.json");
        ObjectMapper objectMapper = new ObjectMapper();

        customersList = objectMapper.readValue(file, new TypeReference<List<Customer>>() {
        });
    }

    /**
     * Busca un cliente por su ID.
     *
     * @param id El ID del cliente.
     * @return El cliente si se encuentra, o null si no se encuentra.
     */
    @Override
    public Customer findCustomerById(int id) {
        return customersList.stream()
                .filter(customer -> customer.getUserId() == id)
                .findFirst()
                .orElse(null);
    }

    /**
     * Permite a un usuario seguir a un cliente.
     *
     * @param userId El ID del usuario que quiere seguir al cliente.
     * @param userIdToFollow El ID del cliente a seguir.
     * @return Verdadero si el usuario pudo seguir al cliente, falso en caso contrario.
     */
    @Override
    public boolean userIdToFollowCustomer(int userId, int userIdToFollow) {

        //se busca el id
        Customer customer = customersList.stream()
                .filter(value -> value.getUserId() == userId).findFirst().orElse(null);

        if (customer == null) return true;

        //regresa true si se encuentra id
        customer.addSeller(userIdToFollow);

        return false;
    }

    /**
     * Obtiene una lista de todos los clientes.
     *
     * @return Una lista de clientes.
     */
    public List<Customer> getCustomersList() {
        customersList.forEach(System.out::println);
        return customersList;
    }

    /**
     * Obtiene una lista de clientes que siguen a un vendedor específico.
     *
     * @param id El ID del vendedor.
     * @return Una lista de clientes que siguen al vendedor.
     */
    @Override
    public List<Customer> getCustomersThatFollowsSellersById(int id) {
        return  customersList.stream()
                .filter( v -> v.getSellers().contains(id))
                .toList();
    }
}
