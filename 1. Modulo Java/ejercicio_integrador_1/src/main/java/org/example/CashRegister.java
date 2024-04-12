package org.example;


import java.util.*;

public class CashRegister {
    private List<Client> clientList;
    private List<Invoice> invoiceList;
    private final List<Item> availableItems;

    public CashRegister() {
        this.clientList = getInitialClients();
        this.availableItems = getInitialItems();
        this.invoiceList = new ArrayList<>();
    }

    public List<Client> getInitialClients() {
        return new ArrayList<>(Arrays.asList(
                new Client(81928342, "Juan", "Sol"),
                new Client(1001292, "Maria", "Rocha"),
                new Client(2029933, "Martin", "Real")
        ));
    }

    private List<Item> getInitialItems() {
        return new ArrayList<>(Arrays.asList(
                new Item(1, "Lechuga", 2, 1200),
                new Item(2, "Tomate", 3, 3000),
                new Item(3, "Queso", 5, 2550),
                new Item(4, "Uvas", 10, 12),
                new Item(5, "Ladrillo", 70, 500)
                ));
    }

    public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }

    public List<Item> getAvailableItems() {
        return availableItems;
    }

    public Client getClientByDni(long clientDni) {
        return this.clientList.stream()
                .filter(client -> client.getDni() == clientDni)
                .findAny()
                .orElse(null);
    }

    public Client getOrCreateClientByDni(long clientDni) {
        Client foundClient = getClientByDni(clientDni);
        if (foundClient == null) foundClient = createClient(clientDni);

        return foundClient;
    }

    public void createInvoice(Client client) {
        Invoice newInvoice = new Invoice(client, this.availableItems);
        this.invoiceList.add(newInvoice);
        System.out.println("Factura generada");
        newInvoice.printDetails();
    }

    public Client createClient(long clientDni) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Ingresa tu nombre");
        String name = userInput.next();
        System.out.println("Ingresa tu apellido");
        String lastname = userInput.next();
        Client newClient = new Client(clientDni, name, lastname);
        this.clientList.add(newClient);
        return newClient;
    }

    public void deleteClientByDni(long clientDni) {
        Client foundClient = getClientByDni(clientDni);
        if (foundClient == null) {
            System.out.println("Ese usuario no existe");
            return;
        }
        this.clientList.remove(foundClient);
        System.out.println("El cliente fue removido");
    }
}
